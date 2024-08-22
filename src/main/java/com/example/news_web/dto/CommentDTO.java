package com.example.news_web.dto;

import com.example.news_web.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private String id;

    private String content;

    private NewsItemDTO newsItemDTO;

    public static CommentDTO init(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setContent(comment.getContent());
        commentDTO.setNewsItemDTO(NewsItemDTO.init(comment.getNewsItem()));
        return commentDTO;
    }
}
