package com.greatlearning.librarymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.librarymanagement.entity.Book;
import com.greatlearning.librarymanagement.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> listAll() {
		
		List<Book> books = bookRepository.findAll();
		
		return books;
	}

	@Override
	public void save(Book book) {
		
		bookRepository.save(book);		
	}

	@Override
	public Book findById(int bookId) {
		
		return bookRepository.findById(bookId).get();
	}

	@Override
	public void deleteById(int bookId) {
		
		bookRepository.deleteById(bookId);
	}

	@Override
	public List<Book> searchBy(String name, String author){
		
		return bookRepository.findByNameContainsAndAuthorContainsAllIgnoreCase(name, author);
	}
	
}
