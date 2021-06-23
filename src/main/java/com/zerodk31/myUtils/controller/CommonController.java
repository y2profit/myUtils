package com.zerodk31.myUtils.controller;

import com.zerodk31.myUtils.MyCustomValidator;
import com.zerodk31.myUtils.vo.ValidVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CommonController {

    @Autowired
    MyCustomValidator myCustomValidator;

    @PostMapping("/valid")
    public ResponseEntity<String> test(@RequestBody @Valid ValidVo vo) {

        System.out.println("vo = " + vo.toString());

        return ResponseEntity.ok().body("success");
    }

    @PostMapping("/validList")
    public ResponseEntity<String> validList(@RequestBody @Valid List<ValidVo> vos, BindingResult bindingResult) throws Exception {
        myCustomValidator.validate(vos, bindingResult);
        if(bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }

        return ResponseEntity.ok().body("success");
    }
}
