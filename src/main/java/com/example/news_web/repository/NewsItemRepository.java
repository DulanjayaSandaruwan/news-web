package com.example.news_web.repository;

import com.example.news_web.model.NewsItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsItemRepository extends JpaRepository<NewsItems, String> {
}
