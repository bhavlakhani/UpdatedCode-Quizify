package com.stackroute.quizify.userauthentication.controller;
import com.stackroute.quizify.userauthentication.domain.User;
import com.stackroute.quizify.userauthentication.exceptions.PasswordNotMatchException;
import com.stackroute.quizify.userauthentication.exceptions.UserAlreadyExists;
import com.stackroute.quizify.userauthentication.exceptions.UserNameNotFoundException;
import com.stackroute.quizify.userauthentication.exceptions.UserNameOrPasswordEmpty;
import com.stackroute.quizify.userauthentication.jwt.SecurityTokenGenrator;
import com.stackroute.quizify.userauthentication.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
@CrossOrigin(value = "*")
@RequestMapping("api/")
@RestController

public class UserController {
    private UserService userService;
ResponseEntity responseEntity;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @ApiOperation(value = "Accept user into repository and generating token")
    @PostMapping("user")
    public ResponseEntity  login(@RequestBody User loginDetails) throws ServletException {

        try {

            String username = loginDetails.getName();
            String password = loginDetails.getPassword();


            if (username == null || password == null) {

                throw new UserNameOrPasswordEmpty("Username and Password cannot be empty");

            }



            User user = userService.findByUserIdAndPassword(username, password);



            if (user == null) {

                throw new UserNameNotFoundException("User with given Id does not exists");

            }





            String fetchedPassword = user.getPassword();

            if (!password.equals(fetchedPassword)) {

                throw new PasswordNotMatchException("Invalid login credential, Please check username and password ");

            }


            // generating token

            SecurityTokenGenrator securityTokenGenrator = (User userDetails) -> {



                String jwtToken = "";

                jwtToken = Jwts.builder().setId(""+user.getId()).setSubject(user.getRole()).setAudience(user.getName()).setIssuedAt(new Date())

                        .signWith(SignatureAlgorithm.HS256, "secretkey").compact();



                Map<String, String> map1 = new HashMap<>();

                map1.put("token", jwtToken);

                map1.put("message", "User successfully logged in");

                return map1;

            };
            Map<String, String> map = securityTokenGenrator.generateToken(user);
            return new ResponseEntity<>(map, HttpStatus.OK);





        } catch (UserNameOrPasswordEmpty | UserNameNotFoundException| PasswordNotMatchException exception) {



            return new ResponseEntity<>("{ \"message\": \"" + exception.getMessage() + "\"}", HttpStatus.UNAUTHORIZED);

        }





    }
    @ApiOperation(value = "Gets all the user details(username,password,role)")
    @GetMapping("user")
    public ResponseEntity<?> getAllUser()
    {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @ApiOperation(value = "It saves all the user details")
    @PostMapping("users")
    public ResponseEntity<?> saveEvent(@RequestBody User user) {

        try {

            userService.saveUser(user);

            responseEntity = new ResponseEntity<User>(user, HttpStatus.OK);

        }
        catch ( UserAlreadyExists ex){

            responseEntity =  new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);

        }

        return responseEntity;

    }





}


//
//
////        ResponseEntity responseEntity;
//
//            String role=user.getRole();
//            String userId=user.getUserid();
//            String pwd=user.getPassword();
//
//        User user1 = userService.findByUserIdAndPassword(userId, pwd);
//
//        try {
//            if (user.getUserid().equalsIgnoreCase(" ")|| user.getPassword().equalsIgnoreCase(" ")) {
//                logger.warn("Please fill in username and password");
//                throw new UserNameOrPasswordEmpty("Please fill in username and password");
//            }
//            else
//            {
//                userService.saveUser(user);
//                return new ResponseEntity<User>(user, HttpStatus.CREATED);
//            }
//
//            // generating token
//
//            SecurityTokenGenrator securityTokenGenrator = (User userDetails) -> {
//
//
//
//                String jwtToken = "";
//
//                jwtToken = Jwts.builder().setId(user1.getUserid()).setSubject(user1.getRole()).setIssuedAt(new Date())
//
//                        .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
//
//
//
//                Map<String, String> map1 = new HashMap<>();
//
//                map1.put("token", jwtToken);
//
//                map1.put("message", "User successfully logged in");
//
//                return map1;
//
//            };
//            Map<String, String> map = securityTokenGenrator.generateToken(user);
//
//
//
//            return new ResponseEntity<>(map, HttpStatus.OK);
//
//
//
//
//        }
//
//        catch (UserNameOrPasswordEmpty e) {
//            return new ResponseEntity<String>("username or password is empty", HttpStatus.CONFLICT);
//
//        }




