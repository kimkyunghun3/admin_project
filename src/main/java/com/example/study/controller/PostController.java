package com.example.study.controller;


import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {


    @PostMapping(value = "/postMethod") //http post body -> data 넣어서 보내겠다
    public SearchParam postMethod(@RequestBody SearchParam searchParam){



        return searchParam;
    }
}
