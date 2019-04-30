package academy.learnprogramming.controller;

import academy.learnprogramming.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // fields
    private final DemoService demoService;

    //constructors
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // methods
    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // http://localhost:8080/todo-list/welcome
    @GetMapping("welcome")
    public String welcome(Model model) {
        model.addAttribute("helloMessage", demoService.getHelloMessage("Stevie"));
        log.info("welcome.jsp served model {}", model);
        return "welcome";
    }

    // model attributes
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcome message called");
        return demoService.getWelcomeMessage();
    }
}