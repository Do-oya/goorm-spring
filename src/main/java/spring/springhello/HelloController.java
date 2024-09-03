package spring.springhello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static org.apache.coyote.http11.Constants.a;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/requestMappingGetTest")
    public String requestMappingGetTest(Model model) {
        model.addAttribute("textFromController", "Hello World!");
        return "requestHello";
    }

    @RequestMapping("/requestParamTest")
    public String requestParamTest(@RequestParam(name = "a", required = false, defaultValue = "0") int a,
                                   @RequestParam("b") String b,
                                   @RequestParam(name = "c", defaultValue = "true") boolean c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        return "hello";
    }

    @RequestMapping("/requestParamMapTest")
    public String requestParamMapTest(@RequestParam Map<String, String> map) {
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        return "hello";
    }

    @RequestMapping("/pathVariableTest/{a}/{b}/{c}")
    public String pathVariableTest(
            @PathVariable("a") String a,
            @PathVariable("b") String b,
            @PathVariable("c") String c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        return "hello";
    }


}
