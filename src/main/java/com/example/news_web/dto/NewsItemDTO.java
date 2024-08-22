package com.example.news_web.dto;

import com.example.news_web.model.NewsDetails;
import com.example.news_web.model.NewsItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsItemDTO {
    private String id;

    private String news;

    private NewsItems.NewsStatus status;

    private List<NewsCategoryDTO> categories;

    public static NewsItemDTO init(NewsItems newsItems) {
        NewsItemDTO newsItemDTO = new NewsItemDTO();
        newsItemDTO.setId(newsItems.getId());
        newsItemDTO.setNews(newsItems.getNews());
        newsItemDTO.setStatus(newsItems.getStatus());
        return newsItemDTO;
    }

    public static NewsItemDTO initWithCategory(NewsItems newsItems, Set<NewsDetails> newsDetails) {
        NewsItemDTO newsItemDTO = NewsItemDTO.init(newsItems);
        List<NewsCategoryDTO> categoryDTOs = newsDetails.stream()
                .map(details -> NewsCategoryDTO.init(details.getNewsCategory()))
                .collect(Collectors.toList());
        newsItemDTO.setCategories(categoryDTOs);

        return newsItemDTO;
    }
}
