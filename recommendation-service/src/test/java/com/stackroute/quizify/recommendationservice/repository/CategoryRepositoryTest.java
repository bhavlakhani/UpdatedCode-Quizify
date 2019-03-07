//package com.stackroute.quizify.recommendationservice.repository;
//
//import com.stackroute.quizify.recommendationservice.domain.Category;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class CategoryRepositoryTest {
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//    private Category category;
//
//    @Before
//    public void setUp() throws Exception {
//        category=new Category();
//        category.setName("Jayashree");
//        category.setImageUrl("imgURL");
//        category.setId(1);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        categoryRepository.deleteAll();
//    }
//
//    @Test
//    public void getAllNodes(){
//        Category category1=new Category(1,"Jayashree","imageURL1");
//        Category category2=new Category(2,"Santhoshi","imageURL2");
//        categoryRepository.save(category1);
//        categoryRepository.save(category2);
//        List<Category> categoryList=categoryRepository.getAllNodes();
//        Assert.assertEquals("Jayashree",categoryList.get(0).getName());
//    }
//}
