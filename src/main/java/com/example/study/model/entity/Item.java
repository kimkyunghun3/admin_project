package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"orderDetailList", "partner"})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String title;
    private String name;

    private String content;

    private Integer price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    private Long partnerId;

    // Item N : 1 Partner
    @ManyToOne
    private Partner partner;



    //Item 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;



    // LAZY = 지연로딩, EAGER = 즉시로딩
    // LAZY = SELECT * FROM item where id =? 아이디에 대해서만 찾아온다

    // EAGER = 1:1 에서 사용하는 것을 추천!!
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?
    // JOIN item item0_ left outer join order_detail orderdetai1_ on item0_.id=orderdetai1_.item_id left outer join user user2_ on orderdetai1_.user_id=user2_.id where item0_.id=?
    //JOIN 으로 가져오므로 성능 저하 및 다 가져오지 못할 수 있으므로 LAZY로 하는게 낫다.

//    // 1 : N
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item" ) //orderDetail 에 있는 item 선언으로 한다고 동일하게 적는다
//    private List<OrderDetail> orderDetailList;
}
