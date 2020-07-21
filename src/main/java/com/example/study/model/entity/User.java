package com.example.study.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data //객체 생성
@AllArgsConstructor
@NoArgsConstructor
@Entity //== table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    // 1: N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")       //OrderDetail 클래스에서 mappedBy(어떤 변수에 매칭 시킬것 이라는 뜻)는 User에서 선언한 user로 동일하게 적어야 된다.
    private List<OrderDetail> orderDetailList; //List로 받아온다
}
