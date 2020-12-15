package com.doancuoiki.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.doancuoiki.demo.Entity.Book;
import com.doancuoiki.demo.Repository.BookRepository;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/books")
public class BookController {
	private BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping
	public List<Book> getAll() {
		List<Book> books = this.bookRepository.findAll();
		return books;
	}

	@PostMapping
	public void insert(@RequestBody Book book) {
		this.bookRepository.insert(book);
	}

	@PostMapping("/{id}")
	public void update(@RequestBody Book nbook,@PathVariable("id") String id) {
		Optional<Book> book = this.bookRepository.findById(id);
		book.get().setTitle(nbook.getTitle());
		book.get().setAuthor(nbook.getAuthor());
		book.get().setPrice(nbook.getPrice());
		book.get().setImage(nbook.getImage());
		this.bookRepository.save(book.get());
	}

	@GetMapping("/{id}")
	public Book getById(@PathVariable("id") String id) {
		Optional<Book> book = this.bookRepository.findById(id);
		return book.get();
	}
	@DeleteMapping("/{id}")
	public void deletedyId(@PathVariable("id") String id) {
		this.bookRepository.deleteById(id);
	}
}
