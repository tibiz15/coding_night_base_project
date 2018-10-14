package controller;

import entyties.SoApplication;
import entyties.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.ApplicationService;

import java.security.Principal;

@Controller
@RequestMapping("/student")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @Transactional
    public ModelAndView addApplication(@RequestParam String name, @RequestParam String description
            , @RequestParam String aim, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("application");
        User author = applicationService.getUserByName(principal.getName());
        SoApplication soApplication = new SoApplication(author.getUserId(), name, description, aim, false, 0);
        applicationService.insertApplication(soApplication);
        return modelAndView;
    }

}
