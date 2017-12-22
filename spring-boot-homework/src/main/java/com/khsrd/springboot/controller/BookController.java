/**
 * 
 */
package com.khsrd.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.khsrd.springboot.model.Book;
import com.khsrd.springboot.service.BookService;
import com.khsrd.springboot.service.PublisherService;
import com.khsrd.springboot.service.UploadFileService;

/**
 * @author Wethtorang
 */
@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private UploadFileService uploadFileService;
	@Autowired
	private PublisherService publisherService;
	
	@RequestMapping(value = {"/home","/"})
	public String index(Model model) {
		model.addAttribute("books", bookService.getAllBook());
		return "book/index";
	}
	@RequestMapping(value = "/detail/{id}")
	public String about(@PathVariable("id")int id,Model model) {
		System.out.println("Id :"+id);
		model.addAttribute("book", bookService.getBookById(id));
		return "book/about";
	}
	
	@RequestMapping(value ="/book/add",method=RequestMethod.GET)
	public String getInput(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("publishers", publisherService.getAllPublisher());
		model.addAttribute("status", true);
		return "book/form";
	}
	
	@RequestMapping(value ="/edit/{id}")
	public String getInput(Model model,@PathVariable("id")int id) {
		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		model.addAttribute("status", false);
		model.addAttribute("publishers", publisherService.getAllPublisher());
		return "book/form";
	}
	@RequestMapping(value="/book/update", method= RequestMethod.POST)
	public String postUpdate(@ModelAttribute("book") Book book,@RequestParam("file") MultipartFile file) {
		if(file.getSize()!=0 || (!file.isEmpty())) {
			System.out.println("True");
			book.setCoverImage(uploadFileService.uploadFile(file));
		}
		bookService.updateBook(book);
		//System.out.println("AAAAAAAAAAAAA");
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/book/add", method= RequestMethod.POST)
	@Transactional
	public String getAdd(@RequestParam(name ="publisher") int[] publisher,@Valid @ModelAttribute("book") Book book,BindingResult result,Model model,@RequestParam("file") MultipartFile file) {
		System.out.println("size : " + result.getErrorCount());
		if(result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField());
				System.out.println(error.getDefaultMessage());
			}

			model.addAttribute("book", book);
			model.addAttribute("status", true);
			return "book/form";
		}
		
		book.setCoverImage(uploadFileService.uploadFile(file));
		bookService.saveBook(book);
		for (int data : publisher) {
			System.out.println("data "+ data +":"+book.getId());
			publisherService.savePublisher(book.getId(), data);
		}
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/remove/{id}", method= RequestMethod.GET)
	public String getAdd(@PathVariable("id")int id) {
		bookService.deleteBook(id);
		return "redirect:/home";
	}
	
	@RequestMapping("/user")//user?name=parameter
	@ResponseBody
	public String getUser(@RequestParam(name ="name" , required=false, defaultValue="name") String name) {
		return name;
	}
	
}
