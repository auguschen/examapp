package com.airchina.xn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.dao.BookDAO;
import com.airchina.xn.entities.Book;
import com.airchina.xn.service.BooksService;

@Service("booksService")
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BookDAO bookdao;
	
	@Override
	public List<Book> getAllBooks() {
		return bookdao.getAllBooks();
	}

	@Override
	public Book getBookById(Integer id) {
		return bookdao.getBookById(id);
	}

}
