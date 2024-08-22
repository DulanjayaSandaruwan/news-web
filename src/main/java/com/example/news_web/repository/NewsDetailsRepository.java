package com.example.news_web.repository;

import com.example.news_web.model.NewsDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface NewsDetailsRepository extends JpaRepository<NewsDetails, String> {
    Set<NewsDetails> findByNewsItemId(String newsItemId);
}
