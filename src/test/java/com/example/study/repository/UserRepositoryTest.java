package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import com.example.study.model.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

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

    @Test
    public void read(){
        Optional<User> user = userRepository.findById(2L);       //userRepository를 불러서 CRUD 구현할 수 있도록 만든다

        user.ifPresent(selectUser -> {
            System.out.println("user : "+selectUser);
            System.out.println("email : "+ selectUser.getEmail());
        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method(");

            userRepository.save(selectUser);

        });

    }

    public void delete(){

    }

}
