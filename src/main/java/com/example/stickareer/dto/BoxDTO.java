package com.example.stickareer.dto;

public class BoxDTO {
    private Long id;
    private String name;
    private String title;
    private String description;
    private String icon;
    
    // 필요한 필드들 추가
    
    // 기본 생성자
    public BoxDTO() {}
    
    // getter와 setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public BoxDTO(Long id, String title, String description, String icon) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.icon = icon;
    }
} 