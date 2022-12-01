package com.librarysys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.librarysys.common.R;
import com.librarysys.entity.Books;
import com.librarysys.service.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/books")
@Slf4j
@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;

    /**
     * 显示所有图书
     * @return
     */
//    @RequestMapping("/showallbooks")
//    public String showAllBooks(){
//        return booksService.queryAll().toString();
//    }

    /**
     * 员工信息的分页查询
     * @param page
     * @param pageSize
     * @param title
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String title) {
        log.info("page = {}, pageSize = {}, name = {}", page, pageSize, title);

        //构造分页构造器
        Page<Books> pageInfo = new Page(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Books> queryWrapper = new LambdaQueryWrapper();

        //添加一个过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(title), Books::getTitle, title);

        //添加排序条件
        queryWrapper.orderByDesc(Books::getIsbn);

        //执行查询
        booksService.page(pageInfo, queryWrapper);

        return R.success(pageInfo);
    }
}
