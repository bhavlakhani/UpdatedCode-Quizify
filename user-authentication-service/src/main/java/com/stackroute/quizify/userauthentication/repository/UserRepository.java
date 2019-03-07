package com.stackroute.quizify.userauthentication.repository;

import com.stackroute.quizify.userauthentication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{

     User findByNameAndPassword(String username,String password);

     boolean existsByName(String name);
}
