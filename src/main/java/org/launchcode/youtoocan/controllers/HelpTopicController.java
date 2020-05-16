package org.launchcode.youtoocan.controllers;

import org.launchcode.youtoocan.models.HelpTopic;
import org.launchcode.youtoocan.models.data.HelpTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HelpTopicController {

    @Autowired
    private HelpTopicRepository helpTopicRepository;

    @GetMapping("createhelptopic")
    public String createHelpTopic(Model model)
    {
        model.addAttribute(new HelpTopic());
        return "createhelptopic";

    }

}
