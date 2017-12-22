/**
 * 
 */
package com.khsrd.springboot.model;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Wethtorang
 */
public class Book {
	
	
	private Integer id;
	@Size(min=1,max = 50)
	private String title;
	@NotEmpty
	private String publicDate;
	@NotEmpty
	private String author;
	@NotEmpty
	private String page;
	private String coverImage;
	private List<Publisher> lists;
	
	
	public List<Publisher> getLists() {
		return lists;
	}

	public void setLists(List<Publisher> lists) {
		this.lists = lists;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Book(int id, String title, String publicDate, String author, String page, String coverImage) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.publicDate = publicDate;
//		this.author = author;
//		this.page = page;
//		this.coverImage = coverImage;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublicDate() {
		return publicDate;
	}

	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

}
