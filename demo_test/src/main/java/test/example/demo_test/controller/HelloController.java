package test.example.demo_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    
    @GetMapping("hello")
    public String hello(Model model){
    model.addAttribute("data", "레그레이즈");
    return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    @GetMapping("hello-String")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "어이 신입 " + name;
    }
    
    @GetMapping("hello-api")
    @ResponseBody
    public Hellos helloApi(@RequestParam("name") String name){
        Hellos hellos = new Hellos();
        hellos.setName(name);
        return hellos;
        
    }
    
    static class Hellos{
        private String name;
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    }
    
    
}
