package com.example.study.model.repository;


import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//
//    // select * from user where account = ? << test03, test04
//    Optional<User> findByAccount(String account); //JPA 에서는 Select문 인것을 findBy를 보고 알게 되고 account와 매칭을 시켜 account에 들어가는 값이 들어간다.
//
//    Optional<User> findByEmail(String email);
//
//
//    // select * fro, user where account = ? and email = ?
//    Optional<User> findByAccountAndEmail(String account, String email);
}
