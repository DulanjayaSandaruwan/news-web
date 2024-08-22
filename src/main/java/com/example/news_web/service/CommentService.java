package com.example.news_web.service;

import com.example.news_web.dto.CommentDTO;
import com.example.news_web.model.Comment;
import com.example.news_web.model.NewsItems;
import com.example.news_web.repository.CommentRepository;
import com.example.news_web.repository.NewsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private NewsItemRepository newsItemRepository;

    @Transactional
    public Comment addComment(CommentDTO commentDTO) {
        Comment comment = Comment.init(commentDTO);
        NewsItems newsItems = newsItemRepository.findById(commentDTO.getNewsItemDTO().getId())
                .orElseThrow(() -> new RuntimeException("NewsItem not found"));
        comment.setContent(commentDTO.getContent());
        comment.setNewsItem(newsItems);
        return commentRepository.save(comment);
    }
}
