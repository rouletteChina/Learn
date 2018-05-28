package com.demo.helloworld.repository;

import com.demo.helloworld.entity.BookMb;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMbDao {

    @Select("SELECT * FROM t_book")
    @Results({@Result(id = true, property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "author", column = "author")})
    public List<BookMb> findAll();

    @Select("SELECT * FROM t_book WHERE id = #{id}")
    @Results({@Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "author", column = "author")})
    public BookMb getOne(Integer id);

    @Insert("INSERT INTO t_book(name,author) VALUES(#{name}, #{author})")
    public void save(BookMb bookMb);

    @Update("UPDATE t_book SET name=#{name},author=#{author} WHERE id =#{id}")
    public void update(BookMb bookMb);

    @Delete("DELETE FROM t_book WHERE id =#{id}")
    public void deleteById(Integer id);

}
