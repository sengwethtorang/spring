package com.khsrd.springboot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.khsrd.springboot.model.Book;
import com.khsrd.springboot.model.Publisher;


@Repository
public interface DbBookRepository {

	@Select("select id, title, publicDate, author,page,coverImage from book order by id")
	@Results({
		@Result(property ="id",column= "id"),
		@Result(property="lists", column="id", many = @Many(select="findPublisherById"))
	})
	public List<Book> getAllBook();

	@Select("select id, title, publicDate, author,page,coverImage from book where id=#{id}")
	@Results({
		@Result(property ="id",column= "id"),
		@Result(property="lists", column="id", many = @Many(select="findPublisherById"))
	})
	public Book getBookById(Integer id);

	@Insert("insert into book(title, publicDate,author, page,coverImage) values( #{title},#{publicDate}, #{author}, #{page},#{coverImage})")
	@SelectKey(before = false, statement = "SELECT LAST_INSERT_ID()", keyColumn = "id", keyProperty = "id", resultType = Integer.class)
	public boolean addBook(Book Book);

	@Delete("delete from book where id=#{id}")
	public boolean remove(Integer id);

	@Update("update book set title=#{title}, publicDate=#{publicDate}, author=#{author} , page=#{page}, coverImage=#{coverImage} where id=#{id}")
	public boolean updateBook(Book Book);
	
	
	@Select("select p.id, p.name from  publisher p inner join bookpublic bp on p.id = bp.publisher_id where bp.book_id = #{id}")
	public List<Publisher> findPublisherById(int id);
}
