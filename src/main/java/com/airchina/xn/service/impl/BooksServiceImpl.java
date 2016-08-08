package com.airchina.xn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.dao.BooksMapper;
import com.airchina.xn.entities.Books;
import com.airchina.xn.service.BooksService;

@Service("booksService")
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BooksMapper booksmapper;
	
	@Override
	public List<Books> getAllBooks() {
		return booksmapper.selectAll();
	}

	@Override
	public Books getBookById(Integer id) {
		return booksmapper.selectByPrimaryKey(id);
	}

}
