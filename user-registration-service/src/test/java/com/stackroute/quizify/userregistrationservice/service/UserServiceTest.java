//package com.stackroute.userregistrationservice.service;
//
//
//import User;
//import UserAlreadyExistException;
//import UserNotFoundException;
//import UserRepository;
//import org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class UserServiceTest {
//
//   private User user;
//
//    @Mock
//    UserRepository userRepository;
//
//    @InjectMocks
//    UserServiceImpl userService;
//
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
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
//
//
//    @Test
//    public void saveUserTest() throws UserAlreadyExistException
//    {
//        when(userRepository.save((User)any())).thenReturn(user);
//        User savedUser = userService.saveUser(user);
//        assertEquals(user,savedUser);
//    }
//
//    @Test
//    public void getUserTest()
//    {
//        user = new User();
//        this.user.setUserId(12);
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
//        List<User> userList = new ArrayList<>();
//        userList.add(user);
//
//        userRepository.save(user);
//        when(userRepository.findAll()).thenReturn(userList);
//        List<User> userList2 = userService.getAllUsers();
//        assertEquals(userList,userList2);
//    }
//
//    @Test
//    public void updateUserTest() throws UserNotFoundException
//    {
//
//        when(this.userRepository.existsById((Long) any())).thenReturn(true);
//        when(this.userRepository.save((User) any())).thenReturn(this.user);
//
//        User updatedUser = this.userService.updateUser(this.user);
//        assertEquals(this.user, updatedUser);
//
//        verify(this.userRepository, times(1)).existsById(((Long)any()));
//        verify(this.userRepository, times(1)).save((User) any());
//
//
//    }
//
////
//    @Test
//    public void deleteUserTest() throws UserNotFoundException {
////        boolean status = false;
////        if (this.userRepository.existsById(id) {
////
////            userRepository.deleteById(id);
////            status = true;
////                  return status;
////        } else {
////            throw new UserNotFoundException("User not found");
////        }
////    }
//
//        when(this.userRepository.existsById((Long) any())).thenReturn(true);
//        Long id = this.user.getUserId();
//        User deletedUser = this.userService.deleteUser(id);
//        assertEquals(this.user, deletedUser);
//
//        verify(this.userRepository, times(1)).existsById((Long) any());
//        verify(this.userRepository, times(1)).delete((User) any());
//
//
//    }
//}
