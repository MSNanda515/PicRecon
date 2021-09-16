package com.msnanda515.PicRecon.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api")
public class RandCont {
    @GetMapping
    public String disp() {
        return "Hello";
    }
}
