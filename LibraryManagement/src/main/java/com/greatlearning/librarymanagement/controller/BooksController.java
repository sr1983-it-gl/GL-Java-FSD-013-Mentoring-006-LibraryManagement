package com.greatlearning.librarymanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.librarymanagement.service.BookService;
import com.greatlearning.librarymanagement.entity.Book;

@Controller
@RequestMapping("/books")
public class BooksController {

	@Autowired
	BookService bookService;
	
	@RequestMapping("/list")
	public String handleBookListing(Model model) {
	
		List<Book> books = bookService.listAll();
		
		model.addAttribute("books", books);		
		
		return "book-lister";
	}

	@RequestMapping("/search")
	public String handleSearch(
		@RequestParam("name") String name,
		@RequestParam("author") String author,
		
		Model model) {
	
		if (name.trim().isEmpty() && author.trim().isEmpty()) {
			return "redirect:/books/list";
		}else {
			
			List<Book> books = bookService.searchBy(name, author);
			
			model.addAttribute("books", books);		
			
			return "book-lister";			
		}
		
	}

	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");

		} else {

			model.addObject("msg", "You do not have permission to access this page!");
		}


		model.setViewName("403");
		return model;
	}
	
}
