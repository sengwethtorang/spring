package com.khsrd.springboot.service;

import java.util.List;
import com.khsrd.springboot.model.Book;


public interface BookService {
	

	public List<Book> getAllBook();
	public Book getBookById(int id);
	public void saveBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(int id);
}
