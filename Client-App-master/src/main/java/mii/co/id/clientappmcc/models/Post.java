/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.models;

import lombok.Data;

/**
 *
 * @author WAHYUK
 */
@Data
public class Post {
    
    private Integer userId;
    private Integer id;
    private String title;
    private String body;

    public Post(Post post) {
        this.userId = post.getUserId();
        this.id = post.getId();
        this.title = post.getTitle();
        this.body = post.getBody();
    }

    public Post() {
    }
}
