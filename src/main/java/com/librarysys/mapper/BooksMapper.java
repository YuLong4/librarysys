package com.librarysys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.librarysys.entity.Books;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BooksMapper extends BaseMapper<Books> {
//    List<Books> selectAll();

//    Books selectByISBN(String ISBN);
}
