/**
 * 
 */
package com.khsrd.springboot.service;

import java.util.List;

import com.khsrd.springboot.model.Publisher;

/**
 * @author Wethtorang
 */
public interface PublisherService {
	public List<Publisher> getAllPublisher();
	public void savePublisher(int bookId, int publisherId);
}
