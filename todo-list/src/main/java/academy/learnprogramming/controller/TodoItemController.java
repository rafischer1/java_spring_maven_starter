package academy.learnprogramming.controller;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {
    // request methods for CRUD on items

    // model attributes
    @ModelAttribute
    public TodoData todoData() {
        return new TodoData();
    }

    // handler method for items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

}
