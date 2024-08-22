package com.example.news_web.service;

import com.example.news_web.model.NewsDetails;
import com.example.news_web.repository.NewsDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class NewsDetailsService {

    @Autowired
    private NewsDetailsRepository newsDetailsRepository;

    public Set<NewsDetails> getNewsDetailsForItem(String newsItemId) {
        return newsDetailsRepository.findByNewsItemId(newsItemId);
    }
}
