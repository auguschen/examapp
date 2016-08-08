package com.airchina.xn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airchina.xn.entities.Books;
import com.airchina.xn.service.BooksService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BooksService booksservice;
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String Index(HttpServletRequest request, Model model){
		List<Books> booklist = booksservice.getAllBooks();
		model.addAttribute("books", booklist);
		model.addAttribute("message","Books in Database");
		return "books";
	}

}
