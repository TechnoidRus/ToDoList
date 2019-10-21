package main;

import java.time.LocalDate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

  @RequestMapping(name = "/")
  public String index(){
    return LocalDate.now().toString();
  }
}
