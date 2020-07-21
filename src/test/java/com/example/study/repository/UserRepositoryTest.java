package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import com.example.study.model.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired      //객체를 직접 스프링이 관리하고 의존성을 관리해주겠다. Dependency Injection (DI) 하는 것이다
    private UserRepository userRepository;

    @Test
    public void create(){           //Hihernate의 장점.. 쿼리문 없이 객체 생성이 가능하게 된다.
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gamail.com");
        user.setPhoneNumber("010-3333-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");

        User newUser = userRepository.save(user);
        System.out.println("newUser: " + newUser);
    }
    public void read(){

    }
    public void update(){

    }

}
