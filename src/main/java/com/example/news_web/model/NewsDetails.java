package com.example.news_web.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "news_details")
public class NewsDetails {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "news_item_id", nullable = false)
    private NewsItems newsItem;

    @ManyToOne
    @JoinColumn(name = "news_category_id", nullable = false)
    private NewsCategories newsCategory;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false,updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}
