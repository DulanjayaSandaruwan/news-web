package com.example.news_web.model;

import com.example.news_web.dto.CommentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "comment")
public class Comment {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "content", nullable = false)
    private String content;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn(name = "news_item_id", nullable = false)
    private NewsItems newsItem;

    public static Comment init(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setId(UUID.randomUUID().toString());
        comment.setContent(commentDTO.getContent());
        return comment;
    }

}
