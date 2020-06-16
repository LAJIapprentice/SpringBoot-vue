package com.milearn.controller;

import com.milearn.entity.Book;
import com.milearn.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("book")
public class BookHandler {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page")Integer page,@PathVariable("size")Integer size) {
        Sort sort;
        Pageable pageable = PageRequest.of(page - 1,size);
        return bookRepository.findAll(pageable);
    }


    @PostMapping("/save")
    public String save(@RequestBody Book book) {  //将前端传来json对象转化为user
        Book result = bookRepository.save(book);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    //查询
    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id) {
        return bookRepository.findById(id).get();
    }

    //修改
    @PutMapping("/update")
    public String update(@RequestBody Book book) {  //将前端传来json对象转化为user
        Book result = bookRepository.save(book);
        if (result != null) {
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        bookRepository.deleteById(id);
    }

}
