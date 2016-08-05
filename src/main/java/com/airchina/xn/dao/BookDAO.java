package com.airchina.xn.dao;

import java.util.List;

import com.airchina.xn.entities.Book;

public interface BookDAO {

	public List<Book> getAllBooks();
	
	public Book getBookById(Integer id);
}
