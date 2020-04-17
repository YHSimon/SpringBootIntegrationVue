package com.yh_simon.springbootvue.repository;

import com.yh_simon.springbootvue.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
