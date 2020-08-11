package com.example.study.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data //객체 생성
@AllArgsConstructor
@NoArgsConstructor
@Entity //== table
@ToString(exclude = {"orderGroup"}) //해당 변수와 여기에 이름이 매칭이 되면 롬복이 toString할 때 제외하겠다는 뜻
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String password;

    private String status;

    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;

    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

//    // 1: N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")       //OrderDetail 클래스에서 mappedBy(어떤 변수에 매칭 시킬것 이라는 뜻)는 User에서 선언한 user로 동일하게 적어야 된다.
    private List<OrderGroup> orderGroupList; //List로 받아온다
}
