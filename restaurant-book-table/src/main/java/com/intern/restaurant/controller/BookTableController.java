package com.intern.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.restaurant.model.BookTable;
import com.intern.restaurant.service.BookTableService;

@RestController
@RequestMapping("/book-table")
@CrossOrigin("*")
public class BookTableController {

	@Autowired
	private BookTableService bookTableService;
	
	@PostMapping("/create/")
	public ResponseEntity<?> createBookTable(@RequestBody BookTable bookTable) {
		return ResponseEntity.ok(bookTableService.createBookTable(bookTable));
	}
	
	@GetMapping("/list/")
	public ResponseEntity<?> listBookTable() {
		return ResponseEntity.ok(bookTableService.listBookTable());
	}
}
