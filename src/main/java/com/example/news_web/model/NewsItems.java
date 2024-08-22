package com.example.news_web.model;

import com.example.news_web.dto.NewsItemDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "news_item")
public class NewsItems {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "full_name", nullable = false)
    private String news;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private NewsStatus status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false,updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @OneToMany(mappedBy = "newsItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NewsDetails> newsDetails;

    public enum NewsStatus {
        ACTIVE,
        INACTIVE,
        DELETED
    }

    public static NewsItems init(NewsItemDTO dto) {
        NewsItems newsItems = new NewsItems();
        newsItems.setId(UUID.randomUUID().toString());
        newsItems.setNews(dto.getNews());
        newsItems.setStatus(NewsStatus.ACTIVE);
        return newsItems;
    }
}
