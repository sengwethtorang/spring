package com.khsrd.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khsrd.springboot.model.Book;
import com.khsrd.springboot.repository.DbBookRepository;
import com.khsrd.springboot.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private DbBookRepository bookRepository;

	/* (non-Javadoc)
	 * @see com.khsrd.springboot.service.BookService#getAllBook()
	 */
	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookRepository.getAllBook();
	}

	/* (non-Javadoc)
	 * @see com.khsrd.springboot.service.BookService#getBookById(int)
	 */
	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return bookRepository.getBookById(id);
	}

	/* (non-Javadoc)
	 * @see com.khsrd.springboot.service.BookService#saveBook(com.khsrd.springboot.model.Book)
	 */
	@Override
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.addBook(book);
		
	}

	/* (non-Javadoc)
	 * @see com.khsrd.springboot.service.BookService#updateBook(com.khsrd.springboot.model.Book)
	 */
	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.updateBook(book);
		
	}

	/* (non-Javadoc)
	 * @see com.khsrd.springboot.service.BookService#deleteBook(int)
	 */
	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		bookRepository.remove(id);
	}
	

}
