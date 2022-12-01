package com.librarysys.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.librarysys.mapper.BooksMapper;
import com.librarysys.entity.Books;
import com.librarysys.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books>implements BooksService {

//    @Autowired
//    private BooksMapper booksMapper;
//
//    @Override
//    public List<Books> queryAll() {
//        return booksMapper.selectAll();
//    }
}
