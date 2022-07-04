package com.greatlearning.librarymanagement.service;

import java.util.List;

import com.greatlearning.librarymanagement.entity.Book;

public interface BookService {

	List<Book> listAll();
	
	void save(Book book);
	
	Book findById(int bookId);
	
	void deleteById(int bookId);
	
	List<Book> searchBy(String name, String author);
}
