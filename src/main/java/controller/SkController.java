package controller;

import entyties.SoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.SkService;
import services.ApplicationService;
import services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/student")
public class SkController {

    @Autowired
    SkService skService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    @Transactional
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView("sk");
        modelAndView.addObject("listOfApplications", skService.getUnroad());
        return modelAndView;
    }

    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    @Transactional
    public ModelAndView changeState(SoApplication soApplication, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("sk");
        soApplication.setSkID(userService.getUserByName(principal.getName()).getUserId());
        skService.updateAplicatoion(soApplication);
        return modelAndView;
    }
}
