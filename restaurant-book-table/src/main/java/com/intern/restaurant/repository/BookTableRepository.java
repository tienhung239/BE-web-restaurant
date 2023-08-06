package com.intern.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intern.restaurant.model.BookTable;

@Repository
public interface BookTableRepository extends JpaRepository<BookTable, Integer>{

}
