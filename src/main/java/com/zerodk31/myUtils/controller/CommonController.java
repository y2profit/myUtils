package com.zerodk31.myUtils.controller;

import com.zerodk31.myUtils.vo.ValidVo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class CommonController {

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody @Valid ValidVo vo) {

        System.out.println("vo = " + vo.toString());

        return ResponseEntity.ok().body("success");
    }
}
