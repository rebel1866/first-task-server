package com.balinasoft.firsttask.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "image_category")
@Setter
@Getter
public class ImageCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer imageCategoryId;
    private LocalDateTime creationDate;
    private String categoryName;
}
