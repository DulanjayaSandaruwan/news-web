package com.example.news_web.repository;

import com.example.news_web.model.NewsItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsItemRepository extends JpaRepository<NewsItems, String> {
    @Query("SELECT ni FROM news_item ni JOIN ni.newsDetails nd WHERE nd.newsCategory.id IN :categoryIds")
    List<NewsItems> findByCategoryIds(
            @Param("categoryIds") List<String> categoryIds
    );
}
