package com.example.news_web.controller;

import com.example.news_web.dto.NewsItemDTO;
import com.example.news_web.model.NewsDetails;
import com.example.news_web.model.NewsItems;
import com.example.news_web.service.NewsDetailsService;
import com.example.news_web.service.NewsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/news-item")
public class NewsItemController {

    @Autowired
    private NewsItemService newsItemService;

    @Autowired
    private NewsDetailsService newsDetailsService;

    @PostMapping("/create-item")
    public ResponseEntity<NewsItemDTO> createNews(@RequestBody NewsItemDTO newsItemDTO) {
        NewsItems newsItem = newsItemService.createNews(newsItemDTO);
        Set<NewsDetails> newsDetails = newsDetailsService.getNewsDetailsForItem(newsItem.getId());
        NewsItemDTO responseDTO = NewsItemDTO.initWithCategory(newsItem, newsDetails);
        return ResponseEntity.ok(responseDTO);
    }
}
