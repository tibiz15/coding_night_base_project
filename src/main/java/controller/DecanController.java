package controller;

import entyties.SoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.DecanService;
import services.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/decan")
public class DecanController {

    @Autowired
    DecanService decanService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    @Transactional
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView("decan");
        modelAndView.addObject("listOfApplications", decanService.getUnroad());
        return modelAndView;
    }

    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    @Transactional
    public ModelAndView answer(@RequestParam SoApplication soApplication, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("decan");
        soApplication.setSkID(userService.getUserByName(principal.getName()).getUserId());
        decanService.updateApplication(soApplication);
        return modelAndView;
    }

}
