package com.doancuoiki.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.doancuoiki.demo.Entity.Order;
import com.doancuoiki.demo.Repository.OrderRepository;
@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/orders")
public class OrderController {
	private OrderRepository orderRepository;
	public OrderController(OrderRepository orderRepository) {
		this.orderRepository=orderRepository;
	}
	@GetMapping("/")
	public List<Order> getAllOrder() {
		return this.orderRepository.findAll();
	}
	@GetMapping("/{id}")
	public Order getOrder(@PathVariable("id") String id) {
		Optional<Order> order=this.orderRepository.findById(id);
		return order.get();
	}
	@PostMapping("/")
	public void createOrder(@RequestBody Order order) {
		//System.out.println("Day la Order: "+   order.getOrderlist().get(0).getBook().getPrice());
		this.orderRepository.insert(order);
	}
}
