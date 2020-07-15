package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //Localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path="/getMethod") // Localhost:8080/api/getMethod 호출하면 이곳으로 들어 온다
    public String getRequest(){

        return "Hi getMethod";

    }

    @GetMapping("/getParameter")                 //Getmapping은 RequestMapping과 다르게 메소드를 지정하지 않아도 되고 주소만 지정하면 된다. Localhost:8080/api/getParameter?id=1234&password=abcd
   public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){      //@RequestParam id, pw를 받기 위해서 저렇게 사용한다. 해당 값을 받아서 여기에 넣는다
        String password = "bbbb";
        System.out.println("id : " +id);
        System.out.println("password : " +pwd);

        return id+pwd;     //주소 창 파라미터에 적어서 엔터누르면 웹사이트 화면에 이와 같이 출력된다.

    }

    //Localhost:8080/api/multiParameter?account=abcd&email=study@gmail.com&page=10 검색 변수가 계속 늘어난다.-> 계속 적어나가야된다..-> 계쏙 적어 줄 수 없으므로 객체로 받을 수 있다--model package의 SearchParam
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){           //SeachParam을 만들어서 Parameter를 직접 받아서 온다. ( 문자열을 입력받아 호출한다 )    //String -> SearchParam으로 바꾼다
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());


        return searchParam;     //JSON형태로 출력된다. {"account": "", "email" : "", "page" =0 } 이런 형식으로 출

    }
}
