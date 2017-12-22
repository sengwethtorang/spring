///**
// * 
// */
//package com.khsrd.springboot.repository.impl;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.github.javafaker.Faker;
//import com.khsrd.springboot.model.Book;
//import com.khsrd.springboot.repository.BookRepository;
//
///**
// * @author Wethtorang
// */
//
//@Repository
//public class BookRepositoryImpl implements BookRepository{
//	
//	private List<Book> books= new ArrayList<>();
//	public BookRepositoryImpl() {
//		try {
//		Faker faker = new Faker();
//		for(int i=1; i<20; i++){
//
//			String author = faker.book().author();
//			String title = faker.book().title();
//			DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
//			Date date = faker.date().birthday();
//			String reportDate = df.format(date);
//			String image = faker.internet().image(100, 100, false, null);
//			String page = faker.number().digits(3);
//			Book book = new Book(i, title, reportDate, author, page, image);
//			books.add(book);
//		}
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
//	
//	@Override
//	public List<Book> getAllBook() {
//		// TODO Auto-generated method stub
//		return books;
//	}
//
//	
//	@Override
//	public Book getBookById(int id) {
//		// TODO Auto-generated method stub
//		for(int i=0;i<books.size();i++) {
//			if(books.get(i).getId()==id) {
//				System.out.println("True");
//				return books.get(i);
//			}
//		}
//		return null;
//	}
//
//	
//	@Override
//	public void addBook(Book book) {
//		books.add(book);
//		
//	}
//
//	
//	@Override
//	public void updateBook(Book book) {
//		// TODO Auto-generated method stub
//		for(int i=0;i<books.size();i++) {
//			if(books.get(i).getId()==book.getId()) {
//				books.set(i, book);
//			}
//		}
//
//	}
//
//	
//	@Override
//	public void removeBook(int id) {
//		// TODO Auto-generated method stub
//		for(int i=0;i<books.size();i++) {
//			if(books.get(i).getId()==id) {
//				books.remove(i);
//			}
//		}
//	}
//
//}
