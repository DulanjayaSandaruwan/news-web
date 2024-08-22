package com.example.news_web.controller;

import com.example.news_web.dto.NewsCategoryDTO;
import com.example.news_web.model.NewsCategories;
import com.example.news_web.service.NewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news-category")
public class NewsCategoryController {

    @Autowired
    private NewsCategoryService newsCategoryService;

    @PostMapping("/create-category")
    public ResponseEntity<NewsCategoryDTO> addCategory(
            @RequestBody NewsCategoryDTO newsCategoryDTO)
    {
        NewsCategories category = newsCategoryService.createCategory(newsCategoryDTO);
        NewsCategoryDTO savedNewsCategory = NewsCategoryDTO.init(category);
        return ResponseEntity.ok(savedNewsCategory);
    }
}
