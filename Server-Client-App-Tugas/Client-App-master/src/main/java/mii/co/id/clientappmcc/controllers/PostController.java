/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.controllers;

import mii.co.id.clientappmcc.models.Post;
import mii.co.id.clientappmcc.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author WAHYUK
 */
@Controller
@RequestMapping("post")
public class PostController {
    
    @Autowired
    private PostService postService;
    
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("posts", postService.getAll());
        return "post";
    }
    
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("post", postService.getById(id));
        return "post-form";
    }
    
    @GetMapping("/add")
    public String addForm(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "post-form";
    }
    
    @PostMapping("/add")
    public String create(@ModelAttribute("post") Post post) {
        postService.create(post);
        return "redirect:/post";
    }
    
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("post") Post post) {
        postService.update(id, post);
        return "redirect:/post";
    }
}
