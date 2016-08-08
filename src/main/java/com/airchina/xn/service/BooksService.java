package com.airchina.xn.service;

import java.util.List;

import com.airchina.xn.entities.Books;

public interface BooksService {

	public List<Books> getAllBooks();
	
	public Books getBookById(Integer id);
}
