package com.example.stickareer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Builder;

@Entity
@Table(name = "category")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    @Id
    @Column(name = "category_ID")
    private Integer categoryId;

    @Column(length = 20)
    private String name;

    @Builder
    public Category(Integer categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }
} 