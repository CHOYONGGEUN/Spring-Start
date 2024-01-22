package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","spring!!");
        return "hello";

    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name" )String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody //http에서 헤더부와 바디부가 있는데, 바디부에 return값을 직접 넣어 주겠다는 의미이다.
    public String helloString(@RequestParam("name")String name){
        return "hello " + name;//ex)"hello spring"
        //MVC와의 차이점은 view 없이, 입력한 문자가 그대로 내려간다.
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name")String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}