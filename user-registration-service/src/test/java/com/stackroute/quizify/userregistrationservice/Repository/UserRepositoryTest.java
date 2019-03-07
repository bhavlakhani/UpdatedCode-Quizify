//package com.stackroute.userregistrationservice.Repository;
//
//
//import User;
//import UserRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@DataMongoTest
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//    private User user;
//
//    @Before
//    public void setUp() {
//        user = new User();
//        this.user.setUserId(11);
//        this.user.setUserName("Akhila");
//        this.user.setPassword("Good song");
//        this.user.setConfirmPassword("Good song");
//        this.user.setEmailId("akhila@gmail.com");
//        this.user.setGender("F");
//
//        List<String> interests = new ArrayList<>();
//        interests.add("Movies");
//        interests.add("Tv Shows");
//        this.user.setInterests(interests);
//
//    }
//    @Test
//    public void saveUserTest()
//    {
//        userRepository.save(user);
//        User fetchUser = userRepository.findById(user.getUserId()).get();
//        Assert.assertEquals(3,fetchUser.getUserId());
//    }
//
//    @Test
//    public void getUserTest()
//    {
//        User user = new User(4,"Shreya Goshal","Good","Good", "akhila@gmail.com", Arrays.asList("movies", "tvshows"), "F" );
//        User user1 = new User(5,"DSP","Good", "Good", "akhil@gmail.com", Arrays.asList("movies", "Tvshows"),"M");
//        userRepository.save(user);
//        userRepository.save(user1);
//        List<User> list = userRepository.findAll();
//        Assert.assertEquals(4,list.get(3).getUserId());
//    }
//
//    @Test
//    public void testSaveUserFailure(){
//        User testUser = new User(2, "kajal", "agarwal", "agarwal", "kajal@gmail.com", Arrays.asList('movies', 'tvshows'),"F");
//        userRepository.save(user);
//        User fetchUser = userRepository.findById(user.getUserId()).get();
//        Assert.assertNotSame(testUser,user);
//    }
//
//
//}