package bitcamp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
  @RequestMapping("/hello") // ==> http://localhost:8080/spring/app/hello
  @ResponseBody
  public String hello() {
    return "hello!";
  }
}
