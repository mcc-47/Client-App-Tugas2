/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.controllers;

import java.util.ArrayList;
import java.util.List;
import mii.co.id.clientappmcc.models.Post;
import mii.co.id.clientappmcc.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

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
        List<Post> posts = new ArrayList<>();
        for (Post post : postService.getAll()) {
            post.setBody(StringUtils.abbreviate(post.getBody(), 50));
            post.setTitle(StringUtils.abbreviate(post.getTitle(), 30));
            posts.add(post);
        }
        
        model.addAttribute("posts", posts);
        return "post";
    }
    
    
    @GetMapping("/get-all")
    public @ResponseBody List<Post> getAllProcess() {
        return postService.getAll();
    }
    
    @GetMapping("/{id}")
    public @ResponseBody Post getById(@PathVariable("id") Integer id) {
        return postService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Post delete(@PathVariable("id") Integer id) {
        return postService.delete(id);
    }

    @PostMapping()
    public @ResponseBody Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @PutMapping("/{id}")
    public @ResponseBody Post update(@PathVariable("id") Integer id, @RequestBody Post post) {
        return postService.update(id, post);
    }
}
