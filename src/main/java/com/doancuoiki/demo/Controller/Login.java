package com.doancuoiki.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doancuoiki.demo.Entity.Account;
import com.doancuoiki.demo.Entity.User;
import com.doancuoiki.demo.Repository.UserRepository;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/login")
public class Login {
	private UserRepository userRepository;
	public Login(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	@PostMapping
	public boolean checkout(@RequestBody Account account) {
		List<User> user=this.userRepository.findAll();
		for(int i=0;i<user.size();i++) {
			User item=user.get(i);
			if(item.getEmail().equalsIgnoreCase(account.getEmail())) {
				if(item.getPassword().equalsIgnoreCase(account.getPwd()))
					return true;
			}
		}
		return false;
	}
	
}
