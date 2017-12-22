/**
 * 
 */
package com.khsrd.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khsrd.springboot.model.Publisher;
import com.khsrd.springboot.repository.PublisherRepository;
import com.khsrd.springboot.service.PublisherService;

/**
 * @author Wethtorang
 */
@Service
public class PublisherServiceImpl implements PublisherService{

	/* (non-Javadoc)
	 * @see com.khsrd.springboot.service.PublisherService#getAllPublisher()
	 */
	@Autowired
	private PublisherRepository publisherRepository;
	
	@Override
	public List<Publisher> getAllPublisher() {
		// TODO Auto-generated method stub
		return publisherRepository.getAllPublisher();
	}

	/* (non-Javadoc)
	 * @see com.khsrd.springboot.service.PublisherService#savePublisher(java.lang.String, java.lang.String)
	 */
	@Override
	public void savePublisher(int bookId, int publisherId) {
		// TODO Auto-generated method stub
		System.out.println("BookId :"+bookId +",Pub Id :"+ publisherId);
		publisherRepository.savePublisher(bookId, publisherId);
	}

}
