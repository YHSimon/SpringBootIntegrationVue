package com.yh_simon.springbootvue.controller;


import com.yh_simon.springbootvue.entity.Book;
import com.yh_simon.springbootvue.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookHanlder {
    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageRequest=PageRequest.of(page, size);
        return bookRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book res = bookRepository.save(book);
        if(res!=null){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book res=bookRepository.save(book);
        if(res!=null){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }

}
