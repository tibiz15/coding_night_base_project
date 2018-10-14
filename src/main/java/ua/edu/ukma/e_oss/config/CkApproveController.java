package ua.edu.ukma.e_oss.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;

@Controller
public class CkApproveController {




    @GetMapping("/ckapprove")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        ArrayList<String> temp = new ArrayList<>();
        temp.add("Uіer1");
        temp.add("Uіer2");
        temp.add("Uіer3");

        ArrayList<Test> temp2 = new ArrayList<>();
        temp2.add(new Test("User1",18));
        temp2.add(new Test("User3",11));
        temp2.add(new Test("User2",21));

        model.addAttribute("users", temp2);

        System.out.print(temp2);

        return "ckapprove";
    }


    @PostMapping("/ckapprove")
    public Response postCustomer(@RequestBody Test customer) {

        System.out.print("OK here we are!1");
        // Create Response Object
        Response response = new Response("Done", customer);
        System.out.print("OK here we are!2");
        System.out.print(response.getData());
        return response;
    }

}