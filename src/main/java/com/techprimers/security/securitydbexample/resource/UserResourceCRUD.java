package com.techprimers.security.securitydbexample.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.techprimers.security.securitydbexample.model.Users;
import com.techprimers.security.securitydbexample.service.UserService;


@RequestMapping("/rest/usercrud")
@RestController
public class UserResourceCRUD {
	
	@Autowired
    UserService userService;
	
	@GetMapping("/all")
    public ResponseEntity<List<Users>> hello() {
		List<Users> users = userService.findAllUsers();
		if(users.isEmpty()){
            return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
    }
	
	@PostMapping(value = "/save/",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody Users users,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + users.getName());
 
       /* if (userService.isUserExist(users)) {
            System.out.println("A User with name " + users.getName()+ " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
 
        userService.saveUser(users);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(users.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
