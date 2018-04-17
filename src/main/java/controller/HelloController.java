package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/hello")
public class HelloController {

    @RequestMapping(value = "/test1")
    public String test1() {
        System.out.println("进入方法!");
        return "index";
    }
}
