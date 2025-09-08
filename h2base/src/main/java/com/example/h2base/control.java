package com.example.h2base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class control {

    @RequestMapping("home")
    String list(){
        return"userform";
    }
    
    @Autowired
    repository s;
     
    @RequestMapping("/saveuser")
    String alldetaill(@RequestParam long id,String name,String email){
        entity e =new entity();
        e.setId(id);
        e.setName(name);
        e.setEmail(email);
        s.save(e);
        return"redirect:/users";
    }

    @PostMapping("/saveuser")
    String alldetaill(@ModelAttribute entity e) {
    s.save(e);
    return "redirect:/users";
   }


    @GetMapping("/users")
    String all(Model m){
       List<entity> entity=s.findAll();
       m.addAttribute("entity", entity);
       return "userlist";
    }
    

}
