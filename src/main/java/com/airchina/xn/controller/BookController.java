package com.airchina.xn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.airchina.xn.entities.Book;
import com.airchina.xn.service.BooksService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BooksService booksservice;
	
	@RequestMapping("/index")
	public String Index(HttpServletRequest request, Model model){
		List<Book> booklist = booksservice.getAllBooks();
		model.addAttribute("books", booklist);
		model.addAttribute("message","Running Controller");
		return "books";
	}

}
