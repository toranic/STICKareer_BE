package com.example.stickareer.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import com.example.stickareer.entity.User;

@Entity
@Getter
@NoArgsConstructor
public class UserInterest extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    // 추가 필드들은 요구사항에 맞게 정의하시면 됩니다
} 