package com.example.news_web.service;

import com.example.news_web.dto.NewsCategoryDTO;
import com.example.news_web.model.NewsCategories;
import com.example.news_web.repository.NewsCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class NewsCategoryService {

    @Autowired
    private NewsCategoryRepository newsCategoryRepository;

    public NewsCategories createCategory(NewsCategoryDTO dto) {
        NewsCategories newsCategory = NewsCategories.init(dto);
        newsCategory = newsCategoryRepository.save(newsCategory);
        return (newsCategory);
    }
}
