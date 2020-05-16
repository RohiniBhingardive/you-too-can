package org.launchcode.youtoocan.controllers;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;

@Controller

public class HomeController {

    @RequestMapping("")
    public String landingPage(Model model, HttpServletRequest request) {

        model.addAttribute("username", getLoggedInUserName());
        model.addAttribute("userpic", getLoggedInUserImgUrl());

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

    public String getLoggedInUserName()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        if (authentication instanceof AnonymousAuthenticationToken)
        {
            return null;
        }
        else if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            //username = principal.toString();
            username = ((DefaultOidcUser) principal).getAttributes().get("name").toString();
            //model.addAttribute("userpic", ((DefaultOidcUser) principal).getAttributes().get("picture").toString());
        }

        //model.addAttribute("username", ((DefaultOidcUser) principal).getAttributes().get("email"));
        //model.addAttribute("username", username);

        return username;
    }

    public String getLoggedInUserImgUrl()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (authentication instanceof AnonymousAuthenticationToken)
        {
            return null;
        }
        else {
           return ((DefaultOidcUser) principal).getAttributes().get("picture").toString();
        }

    }

}
