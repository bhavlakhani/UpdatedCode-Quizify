//package com.stackroute.quizify.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.quizify.userauthentication.controller.UserController;
//import com.stackroute.quizify.userauthentication.domain.LoginUser;
//import com.stackroute.quizify.userauthentication.service.UserService;
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
//
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@WebMvcTest
//
//@RunWith(SpringRunner.class)
//
//public class LoginUserControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    private LoginUser user;
//    @MockBean
//    private UserService userService;
//    @InjectMocks
//    private UserController userController;
//    private List<LoginUser> list;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//        user = new LoginUser();
//        user.setUsername("abc@gmail.com");
//        user.setPassword("123");
//        user.setRole("player");
//
//        list = new ArrayList();
//        list.add(user);
//    }
//
//
//    @Test
//    public void saveUser() throws Exception {
//        System.out.println("hello jass!!!!!!!!!");
//        System.out.println(user.getUsername()+user.getRole()+user.getPassword());
//
//        when(userService.saveUser(any())).thenReturn(user);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//
//    }
//
//
//    @Test
//    public void getAllUser() throws Exception {
//        System.out.println(list);
//        when(userService.getAllUsers()).thenReturn(list);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/user")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//    }
//
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
//
//}