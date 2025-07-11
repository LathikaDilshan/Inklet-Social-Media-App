package com.example.inklet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500) // Example length limit [cite: 44]
    private String content; //[cite: 46]

    @Column(nullable = false)
    private LocalDateTime timestamp; //[cite: 46]

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author; //[cite: 46]

    private int likeCount = 0; // For the like system [cite: 70]

    // One-to-many relationship with Likes
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Like> likes;



    // Getters and Setters
    // ...
}