package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data           //자동적으로 기본 생성자, get-set 메소ㄷ, toString, hashcode에 대해 생성해준다.
@AllArgsConstructor //모든 argument에 대한 생성자를 만들기 위해서는 이것을 사용해서 argument를 만들어 준다.
public class SearchParam {

    private String account;
    private String email;
    private int page;


}
