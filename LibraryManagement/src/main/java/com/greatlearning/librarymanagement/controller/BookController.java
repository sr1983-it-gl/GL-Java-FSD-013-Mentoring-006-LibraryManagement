package com.greatlearning.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.librarymanagement.entity.Book;
import com.greatlearning.librarymanagement.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping("/add-begin")
	public String handleBeginAdd(Model model) {
		
		Book book = new Book();
		
		model.addAttribute("book", book);
		
		return "book-details";
	}

	@RequestMapping("/update-begin")
	public String handleBeginAdd(
		@RequestParam("bookId") int bookId,
			Model model) {
		
		Book book = bookService.findById(bookId);
		
		model.addAttribute("book", book);
		
		return "book-details";
	}
	
	@PostMapping("/save")
	public String handleSave(
		@RequestParam("id") int id,
		@RequestParam("name") String name,
		@RequestParam("category") String category,
		@RequestParam("author") String author
			) {
	
		Book book = null;
		if (id == 0) {
			
			// Add book scenario
			
			book = new Book(name, category, author);
			
		}else {
			
			// Update scenario
			
			book = bookService.findById(id);
			
			book.setName(name);
			book.setCategory(category);
			book.setAuthor(author);			
		}
		
		bookService.save(book);
		return "redirect:/books/list";
	}
	
	@RequestMapping("/delete")
	public String handleDelete(
		@RequestParam("bookId") int id) {
		
		bookService.deleteById(id);
		return "redirect:/books/list";
	}
}
