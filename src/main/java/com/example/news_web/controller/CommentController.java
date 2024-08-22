package com.example.news_web.controller;

import com.example.news_web.dto.CommentDTO;
import com.example.news_web.model.Comment;
import com.example.news_web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add-comment")
    public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO commentDTO) {
        Comment comment = commentService.addComment(commentDTO);
        CommentDTO init = CommentDTO.init(comment);
        return ResponseEntity.ok(init);
    }
}
