package com.example.news_web.dto;

import com.example.news_web.model.NewsCategories;
import com.example.news_web.model.NewsItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsCategoryDTO {
    private String id;

    private String categoryName;

    private NewsCategories.CategoryStatus status;

    public static NewsCategoryDTO init(NewsCategories newsCategories) {
        NewsCategoryDTO newsCategoryDTO = new NewsCategoryDTO();
        newsCategoryDTO.setId(newsCategories.getId());
        newsCategoryDTO.setCategoryName(newsCategories.getCategoryName());
        newsCategoryDTO.setStatus(newsCategories.getStatus());
        return newsCategoryDTO;
    }
}
