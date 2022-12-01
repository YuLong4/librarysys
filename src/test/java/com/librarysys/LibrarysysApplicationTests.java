package com.librarysys;

import com.librarysys.controller.BooksController;
import com.librarysys.mapper.BooksMapper;
import com.librarysys.entity.Books;
import com.librarysys.service.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LibrarysysApplicationTests {

    @Autowired
    BooksMapper booksMapper;

    @Autowired
    BooksService booksService;

    @Autowired
    BooksController booksController;

    @Test
    void test_page(){
        System.out.println(booksController.page(1,10,null).getData().getRecords());
    }
//    @Test
//    void test(){
//        System.out.println(booksMapper.selectByISBN("A0001"));
//
//    }
//    @Test
//    void test_selectAll(){
//        List<Books> books = booksMapper.selectAll();
//        System.out.println(books.toString());
//        System.out.println(books.size());
//    }
//
//    @Test
//    void test_queryAll(){
//        System.out.println(booksService.queryAll());
//    }



}
