package com.airchina.xn.service;

import java.util.List;

import com.airchina.xn.entities.Book;

public interface BooksService {

	public List<Book> getAllBooks();
	
	public Book getBookById(Integer id);
}
