package com.balinasoft.firsttask.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "image_category")
@Setter
@Getter
@ToString
public class ImageCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer imageCategoryId;
    private LocalDateTime creationDate;
    private String categoryName;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Image> images;
}
