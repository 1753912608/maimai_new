package maimai_new.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/test_login")
    public String login(){
        return "login";
    }


    @RequestMapping("/center")
    public String personCenter(){
        return "personCenter";
    }
    @RequestMapping("/friends_info")
    public String friends(){
        return "friends";
    }
    @RequestMapping("/createarticle")
    public String createarticle(){
        return "createarticle";
    }
}
