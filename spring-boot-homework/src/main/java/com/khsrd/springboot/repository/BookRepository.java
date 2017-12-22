/**
 * 
 */
package com.khsrd.springboot.repository;

import java.util.List;

import com.khsrd.springboot.model.Book;

/**
 * @author Wethtorang
 */
public interface BookRepository {
	
	
	public List<Book> getAllBook();

	public Book getBookById(int id);

	public void addBook(Book book);

	public void updateBook(Book book);

	public void removeBook(int id);
}
