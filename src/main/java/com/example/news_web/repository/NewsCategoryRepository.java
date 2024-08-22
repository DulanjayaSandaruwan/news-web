package com.example.news_web.repository;

import com.example.news_web.model.NewsCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsCategoryRepository extends JpaRepository<NewsCategories, String> {
    Optional<NewsCategories> findByCategoryName(String name);
}
