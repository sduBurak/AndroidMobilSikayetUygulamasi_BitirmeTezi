package com.bitirmeTez.sikayetPortal.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitirmeTez.sikayetPortal.exception.ResourceNotFoundException;
import com.bitirmeTez.sikayetPortal.model.ResponseAPI;
import com.bitirmeTez.sikayetPortal.model.Users;
import com.bitirmeTez.sikayetPortal.repository.UserRepository;

@RestController
@RequestMapping("/usersAPI")
public class UsersController {

	@Autowired
    private UserRepository userRepository;
	
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UsersController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
	
	@GetMapping("/Users")
    public ResponseAPI<List<Users>> getAllUsers() throws ResourceNotFoundException {			
		List<Users> userList = (List<Users>) userRepository.findAll();	
		userList.stream().forEach(item -> item.setPassword(""));
		return new ResponseAPI<List<Users>>("Success", "Get All Users Successfully", userList );
    }
	
	@PostMapping("/addUser")	
	@Transactional
	public ResponseAPI<Users> addUser(@RequestBody Users user) throws ResourceNotFoundException 
	{		
		Users newUser = new Users();
		newUser.setName(user.getName());
		newUser.setSurname(user.getSurname());
		newUser.setPhone(user.getPhone());		
		newUser.setEmail(user.getEmail());
		newUser.setUsername(user.getUsername());									
	 	newUser.setPassword(user.getPassword());                                       	 		 		 			               
        Users insertedUser = userRepository.save(newUser);                               
        return new ResponseAPI<Users>("Success", "User Created Successfully", insertedUser);
	}
	
	@GetMapping("/login")
	@ResponseBody
    public ResponseAPI<Users> loginUser(@RequestParam String username,@RequestParam String password) throws ResourceNotFoundException {			
		Users usr = userRepository.isLoginUsers(username, password);	
		if(usr != null) {
			usr.getComplaintList().clear();
			return new ResponseAPI<Users>("Success", "Users Read Successfully", usr );
		}
		else {
			return new ResponseAPI<Users>("Success", "User Name or Password Wrong", usr );
		}
    }
	
	
	
}
