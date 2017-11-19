package pers.fpj.answer.a2.domain.hello.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by fpj on 2017/11/18 22:04.
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping()
    public ResponseEntity getUser(String param) {
        String s = "hello " + param;
        return ResponseEntity.ok().body(s);
    }
}
