package com.greatlearning.librarymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.librarymanagement.entity.Book;

public interface BookRepository 
	extends JpaRepository<Book, Integer> {

	
//	// Convention
//	// Method name starting with findBy
//	// NameAndAuthor
//		// name = ? and author = ?
//	// name = 'name value' and author = 'author value'
//	// select * from book where name = 'name value' and author = 'author name' and category = 'category'
//	List<Book> findByNameAndAuthorAndCategory(String one, String two, String there);


	// select * from book where name like '%name value%' and author like '%author value%'
	List<Book> findByNameContainsAndAuthorContainsAllIgnoreCase(String name, String author);
	
}
