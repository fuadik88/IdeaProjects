package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "welcomeform";
    }

    @RequestMapping("/processForm")
    public String procForm() {
        return "confirmationpage";
    }

    @RequestMapping("/processFormv2")
    public String upperCase(HttpServletRequest request, Model model){
        String name = request.getParameter("customerName");
        name = name.concat(" | LTD");
        String output = "Hey! " + name;
        model.addAttribute("message", output);

        return "confirmationpage";
    }
}
