package com.example.study.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //Order_detail 테이블에 자동적으로 연결이 된다.
//@ToString(exclude = {"user", "item"})           //lombok 쓰면 toString 만드는데 이 부분을 user와 OrderDetail가 상호참조하고 있기 떄문에 Overflow 에러가 난다. 그러므로 이를 뺴야 한다. user, item 연관관계 잇는거에대해서는 이처럼 빼줘야 함!
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime orderAt;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}

//    //OrderDetail (N) : user(1) 항상 본인을 기준으로 만든다!
//    @ManyToOne
//    private User user;      //ManyToOne 하게되면 Long 타입이 아니라 객체 유형과 객체 이름으로 다시 설정해야한다. 객체로 설정 해야함! Long이 아니라
//
//    //  N : 1
//    @ManyToOne
//    private Item item;
//}
