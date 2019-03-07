//package com.stackroute.quizify.repository;
//
//import com.stackroute.quizify.repository.UserRepository;
//import com.stackroute.quizify.domain.LoginUser;
//import com.stackroute.quizify.repository.UserRepository;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class UserRepositoryTest {
//
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//
//    private LoginUser user;
//
////
////  @Before
////        public void setUp() {
//////        user = new LoginUser();
//////        user.setUsername("admin1");
//////        user.setPassword("123");
//////        user.setRole("admin");
//////        userRepository.save(user);
////  }
//
////    @Test
////    public void findByUsernameAndPasswordTestSuccess(){
////
////        System.out.println("hello !! i am in repository test");
//            //userRepository.save(user);
////            LoginUser fetched = userRepository.getOne("admin1");
////            Assert.assertEquals(this.user,fetched);
//
//        }
//
////        userRepository.findByUsernameAndPassword("admin","123");
////        user = new LoginUser();
////        this.user.setUsername("ADMIN");
////        this.user.setPassword("123");
////        this.user.setRole("admin");
////        this.userRepository.save(user);
//
////
////       LoginUser user1=this.userRepository.findByUsernameAndPassword(this.user.getUsername(),this.user.getPassword());
//          //  userRepository.findByUsernameAndPassword("ADMIN","123")
//     //  assertEquals(this.user,this.userRepository.findByUsernameAndPassword("ADMIN","123"));
//
//    }
//
