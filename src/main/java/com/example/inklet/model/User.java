package com.example.inklet.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email; // Used for login

    @Column(nullable = false)
    private String passwordHash; // BCrypt hashed password

    @Column(nullable = false)
    private String firstName; //[cite: 30]

    @Column(nullable = false)
    private String lastName; //[cite: 30]

    // One-to-many relationship with Posts
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Post> posts;

    // One-to-many relationship with Likes
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Like> likes;

    // Getters and Setters
    // ... (constructor, equals, hashCode, toString are good practices)
}