package academy.learnprogramming.bootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    @ResponseBody
    @GetMapping("demo")
    public String demo() {
        return "Hello Spring Boot!";
    }

    @GetMapping("welcome")
    public String welcome(Model model) {
        log.info("Welcome model called = {}", model);
        model.addAttribute("message", "welcome to Spring Boot");
        return "welcome";
    }
}

