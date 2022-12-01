package com.librarysys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.librarysys.common.R;
import com.librarysys.entity.Books;
import com.librarysys.service.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


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
     * 图书信息分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        log.info("page = {}, pageSize = {}, name = {}", page, pageSize, name);

        //构造分页构造器
        Page<Books> pageInfo = new Page(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Books> queryWrapper = new LambdaQueryWrapper();

        //添加一个过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name), Books::getTitle, name);

        //添加排序条件
        queryWrapper.orderByDesc(Books::getIsbn);

        //执行查询
        booksService.page(pageInfo, queryWrapper);

        return R.success(pageInfo);
    }

    /**
     * 新增图书
     * @param books
     * @return
     */
    @RequestMapping
    public R<String> save(@RequestBody Books books){
        log.info("新增图书,图书信息:{}",books.toString());

        booksService.save(books);

        return R.success("新增图书成功");
    }

    /**
     * 根据图书isbn修改信息
     * @param books
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Books books) {
        log.info(books.toString());

        booksService.updateById(books);

        return R.success("图书信息修改成功");
    }

    /**
     * 根据isbn查询图书信息
     * @param isbn
     * @return
     */
    @GetMapping("/{isbn}")
    public R<Books> getById(@PathVariable String isbn) {

        Books books = booksService.getById(isbn);
        if(books != null) {
            log.info(books.toString());
            return R.success(books);
        }
        return R.error("加载对应图书信息失败");
    }
}
