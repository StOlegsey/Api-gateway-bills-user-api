package com.bills_user.bills_user_api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HtmlController {

    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String index() {
        System.out.println("Main Page Requested");
        return "index";
    }
}
