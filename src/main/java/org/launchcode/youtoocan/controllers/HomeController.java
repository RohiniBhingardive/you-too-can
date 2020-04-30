package org.launchcode.youtoocan.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {

    @RequestMapping("")
    public String landingPage(Model model) {


        return "index";
    }

    @RequestMapping("wanttohelp")
    public String wantToHelpPage(Model model) {


        return "wanttohelp";
    }

    @RequestMapping("needhelp")
    public String needhelpPage(Model model) {


        return "needhelp";
    }

    @RequestMapping("about")
    public String aboutPage(Model model) {


        return "about";
    }

    @RequestMapping("contact")
    public String contactPage(Model model) {


        return "contact";
    }

}
