package com.example.news_web.model;

import com.example.news_web.dto.NewsCategoryDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "news_category")
public class NewsCategories {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryStatus status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false,updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public enum CategoryStatus {
        ACTIVE,
        INACTIVE,
        DELETED
    }

    public static NewsCategories init(NewsCategoryDTO dto) {
        NewsCategories newsCategories = new NewsCategories();
        newsCategories.setId(UUID.randomUUID().toString());
        newsCategories.setCategoryName(dto.getCategoryName());
        newsCategories.setStatus(CategoryStatus.ACTIVE);
        return newsCategories;
    }
}
