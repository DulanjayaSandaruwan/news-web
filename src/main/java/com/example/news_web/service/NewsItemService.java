package com.example.news_web.service;

import com.example.news_web.dto.FilterNewsItemDTO;
import com.example.news_web.dto.NewsItemDTO;
import com.example.news_web.model.NewsCategories;
import com.example.news_web.model.NewsDetails;
import com.example.news_web.model.NewsItems;
import com.example.news_web.repository.NewsCategoryRepository;
import com.example.news_web.repository.NewsDetailsRepository;
import com.example.news_web.repository.NewsItemRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class NewsItemService {

    @Autowired
    private NewsItemRepository newsItemRepository;

    @Autowired
    private NewsDetailsRepository newsDetailsRepository;

    @Autowired
    private NewsCategoryRepository newsCategoryRepository;

    public NewsItems createNews(NewsItemDTO newsItemDTO) {
        NewsItems newsItem = NewsItems.init(newsItemDTO);
        newsItemRepository.save(newsItem);

        if (newsItemDTO.getCategories() != null && !newsItemDTO.getCategories().isEmpty()) {
            Set<NewsDetails> newsDetailsSet = newsItemDTO.getCategories().stream().map(categoryDTO -> {
                NewsCategories category = newsCategoryRepository.findById(categoryDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryDTO.getId()));

                NewsDetails newsDetails = new NewsDetails();
                newsDetails.setId(UUID.randomUUID().toString());
                newsDetails.setNewsItem(newsItem);
                newsDetails.setNewsCategory(category);

                return newsDetails;
            }).collect(Collectors.toSet());

            newsDetailsRepository.saveAll(newsDetailsSet);
        }
        return newsItem;
    }

    public List<NewsItemDTO> getNewsItemsByCategories(FilterNewsItemDTO filterDTO) {
        List<NewsItems> newsItemsList = newsItemRepository.findByCategoryIds(filterDTO.getCategoryIds());
        return newsItemsList.stream()
                .map(newsItem -> NewsItemDTO.initWithCategory(newsItem, newsItem.getNewsDetails()))
                .collect(Collectors.toList());
    }
}
