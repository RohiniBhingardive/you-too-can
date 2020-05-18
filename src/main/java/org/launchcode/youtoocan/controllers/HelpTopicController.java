package org.launchcode.youtoocan.controllers;

import org.launchcode.youtoocan.models.HelpCategory;
import org.launchcode.youtoocan.models.HelpTopic;
import org.launchcode.youtoocan.models.data.HelpCategoryRepository;
import org.launchcode.youtoocan.models.data.HelpTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller

public class HelpTopicController {

    @Autowired
    private HelpTopicRepository helpTopicRepository;

    @Autowired
    private HelpCategoryRepository helpCategoryRepository;

    @GetMapping("createhelptopic")
    public String createHelpTopic(Model model)
    {
        model.addAttribute(new HelpTopic());
        model.addAttribute("helpCategories", helpCategoryRepository.findAll());

        System.out.println("Rohini: inside GetMapping!");

        return "createhelptopic";

    }

    @PostMapping("createhelptopic")
    public String processCreateHelpTopicForm(@ModelAttribute @Valid HelpTopic helpTopic,
                                    Errors errors, Model model, @RequestParam String title, @RequestParam int helpCategoryId,
                                             @RequestParam String description,
                                    @RequestParam int zipCode) {

        System.out.println("Rohini: inside PostMapping!");

        if (errors.hasErrors()) {
            //model.addAttribute("title", "Test Error Title");
            System.out.println("Rohini: inside postmapping has errors!");
            return "createhelptopic";
        }

        HelpTopic helpTopicToSave = new HelpTopic();
        helpTopicToSave.setTitle(title);
        helpTopicToSave.setDescription(description);
        helpTopicToSave.setZipCode(zipCode);
        helpTopicToSave.setNeedyUser(getLoggedInUserEmail());

        helpTopicToSave.setCategory((HelpCategory) helpCategoryRepository.findById(helpCategoryId).get());


        helpTopicRepository.save(helpTopicToSave);

        return "redirect:";
    }


    public String getLoggedInUserEmail()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String useremail;

        if (authentication instanceof AnonymousAuthenticationToken)
        {
            return null;
        }
        else if (principal instanceof UserDetails) {
            useremail = ((UserDetails) principal).getUsername();
        } else {
            //username = principal.toString();
            useremail = ((DefaultOidcUser) principal).getAttributes().get("email").toString();
            //model.addAttribute("userpic", ((DefaultOidcUser) principal).getAttributes().get("picture").toString());
        }

        //model.addAttribute("username", ((DefaultOidcUser) principal).getAttributes().get("email"));
        //model.addAttribute("username", username);

        return useremail;
    }

}
