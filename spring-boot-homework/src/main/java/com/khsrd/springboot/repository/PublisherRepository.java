/**
 * 
 */
package com.khsrd.springboot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.khsrd.springboot.model.Publisher;

/**
 * @author Wethtorang
 */
@Repository
public interface PublisherRepository {
	@Select("select p.id, p.name from  publisher p order by id")
	public List<Publisher> getAllPublisher();
	
	@Insert("insert into bookpublic(book_id, publisher_id) values (#{bookId} , #{publisherId})")
	public void savePublisher(@Param("bookId") int bookId, @Param("publisherId") int publisherId);
	
}
