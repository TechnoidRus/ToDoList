package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import main.model.Task;
import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

  @Autowired
  private
  TaskRepository taskRepository;

  @RequestMapping(name = "/")
  public String index(Model model) {
    Iterable<Task> allBooks = taskRepository.findAll();
    List<Task> tasks = new ArrayList<>((Collection<? extends Task>) allBooks);
    model.addAttribute("tasks", tasks);
    model.addAttribute("taskCount", tasks.size());
    return "index";
  }
}
