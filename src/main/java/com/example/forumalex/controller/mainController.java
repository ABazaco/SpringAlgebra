package com.example.forumalex.controller;

import com.example.forumalex.domain.Question;
import com.example.forumalex.service.ForumService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class mainController {

    private final ForumService forumService;

    public mainController(ForumService forumService) {
        this.forumService = forumService;
    }

    @Secured("ROLE_USER")
    @GetMapping("/user")
    String getUser(Model model){
        model.addAttribute("something", "this is the user");
        return "pages/people";
    }
    @Secured("ADMIN")
    @GetMapping("/admin")
    String getAdmin(Model model){
        model.addAttribute("something", "this is the admin");
        return "pages/admin";
    }

    @GetMapping("/")
    String index(Model model){
        model.addAttribute("something", "this is the admin from the index");
        return "pages/admin";
    }
    @GetMapping("/addQuestion")
    public String AddQuestion(Question question, Model model){
        model.addAttribute("question", question);
        return "pages/addQuestion";
    }

    @PostMapping("/addQuestionConfirm")
    public String AddQuestionConfirm(@Valid Question question, Errors errors, Model model) {

        if(errors.hasErrors())
        {
            model.addAttribute("question", question);
            return "pages/addQuestion";
        }

        forumService.save(question);
        return displayQuestions(model);
    }


    @GetMapping("/displayQuestions")
    String displayQuestions(Model model){
        model.addAttribute("questions" , forumService.findAll());
        return "pages/displayQuestions";
    }


    @GetMapping("/displayOneQuestion/{id}")
    String displayQuestions(@PathVariable int id, Model model, Authentication authentication){
        Optional<Question> questionShown = forumService.findById(id);

        if(questionShown.isPresent()){
            Question question = questionShown.orElseThrow(RuntimeException::new);
            model.addAttribute("question", question);
            model.addAttribute("name", authentication.getName());

            return "pages/displayOneQuestion";
        }
        model.addAttribute("something", "this is the admin error from display");
        return "pages/admin";
    }


    @RequestMapping("deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable int id, Model model, Authentication authentication){

        forumService.deleteById(id);

        model.addAttribute("something", "   autorities  " +  authentication.getAuthorities() + "   name " + authentication.getName());
        return "pages/admin";

    }


}
