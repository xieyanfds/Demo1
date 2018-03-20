package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xieyan
 * @description
 * @date 2018/3/2.
 */
@Controller
@RequestMapping(value="/api")
public class LoginController {

    @RequestMapping(value="/login")
    public String login(){
        int i =11;
        int j = 12;
        return "login";
    }
}
