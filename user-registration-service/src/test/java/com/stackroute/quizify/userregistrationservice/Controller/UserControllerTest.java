//package com.stackroute.userregistrationservice.Controller;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import UserController;
//import User;
//import UserService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Matchers.anyInt;
//import static org.mockito.Mockito.when;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class UserControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    private User user;
//
//    @MockBean
//    private UserService userService;
//
//    @InjectMocks
//    private UserController userController;
//
//    private List<User> list = null;
//
//    @Before
////    public void setUp()
////    {
////        MockitoAnnotations.initMocks(this);
////        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
////        user = new User();
////        user.setUserId(2);
////        user.setUserName("Taylor Swift");
////        user.setPassword("favourite song");
////        user.setConfirmPassword("favourite song");
////        user.setEmailId("akhila@gmail.com");
////        user.setInterests(Arrays.asList("movies","tvshows"));
////        user.setGender("F");
////
//////        list = new ArrayList<>();
////        list.add(user);
////    }
//
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
//    @Test
//    public void saveUser() throws Exception
//    {
//        when(userService.saveUser(any())).thenReturn(user);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//
//    @Test
//    public void updateUser() throws Exception
//    {
//        when(userService.updateUser(any())).thenReturn(user);
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/user")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getUser() throws Exception
//    {
//
//        when(userService.getAllUsers()).thenReturn(list);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
////    @Test
////    public void deleteUser() throws Exception
////    {
////        when(userService.deleteUser((long) anyInt())).thenReturn(true);
////        mockMvc.perform(MockMvcRequestBuilders.delete("api/v1/user")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andDo(MockMvcResultHandlers.print());
////    }
//
//    private static String asJsonString(final Object obj)
//    {
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//
//        }catch(Exception e){
//            throw new RuntimeException(e);
//        }
//    }
//
//}
