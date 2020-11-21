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
    @RequestMapping("/mychat")
    public String mychat(){
        return "chat";
    }

    @RequestMapping("/reset")
    public String reset(){
        return "resetAccount";
    }

    /**
     * zwl
     */

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/zhaopin")
    public String zhaopin() {
        return "zhaopin";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
}
