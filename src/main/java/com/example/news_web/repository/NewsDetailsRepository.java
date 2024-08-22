package com.example.news_web.repository;

import com.example.news_web.model.NewsDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsDetailsRepository extends JpaRepository<NewsDetails, String> {
    List<NewsDetails> findByNewsItemId(String newsItemId);
}
