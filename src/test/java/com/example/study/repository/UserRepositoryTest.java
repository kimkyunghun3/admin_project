package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import com.example.study.model.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;



import org.junit.Assert;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired      //객체를 직접 스프링이 관리하고 의존성을 관리해주겠다. Dependency Injection (DI) 하는 것이다
    private UserRepository userRepository;

    @Test
    public void create(){           //Hihernate의 장점.. 쿼리문 없이 객체 생성이 가능하게 된다.
        String account ="Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt =LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedBy(createdBy);
        user.setCreatedAt(createdAt);

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);

    }

    @Test
    @Transactional
    public void read(){
//        Optional<User> user = userRepository.findByAccount("TestUser03");       //userRepository를 불러서 CRUD 구현할 수 있도록 만든다
//
//        user.ifPresent(selectUser -> {
//
//            selectUser.getOrderDetailList().stream().forEach(detail -> {        //List 형식으로 가져오므로 stream과 foreach로 만들어서 보여준다.
//                Item item = detail.getItem();
//                System.out.println(item);
//            });
//        });
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");    //이 번호가 있으면 조회된다.

        if(user != null) {
            user.getOrderGroupList().stream().forEach(orderGroup -> {
                System.out.println("--------주문묶음--------");
                System.out.println("수령인 : " + orderGroup.getRevName());
                System.out.println("수령지 : " + orderGroup.getRevAddress());
                System.out.println("총금액 : " + orderGroup.getTotalPrice());
                System.out.println("총수량 : " + orderGroup.getTotalQuantity());

                System.out.println("------주문상세-------");

                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("주문의 상태 : " + orderDetail.getStatus());
                    System.out.println("도착예정일자 : " + orderDetail.getArrivalDate());

                });
            });
        }
        Assert.assertNotNull(user); //assert로 user가 있어야된다고 한다.
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

    @Test
    @Transactional      //Test는 돌아가는데 칼럼에서는 삭제가 안된다. (Rolled back 된다)
    public void delete(){
        Optional<User> user = userRepository.findById(3L);

        Assert.assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);

        });

        Optional<User> deleteUser = userRepository.findById(3L);

        Assert.assertFalse(deleteUser.isPresent());

        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 : "+ deleteUser.get());
        }else{
            System.out.println("데이터 삭제 데이터 없음");
        }
    }
}
