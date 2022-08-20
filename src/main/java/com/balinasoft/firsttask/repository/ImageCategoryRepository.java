package com.balinasoft.firsttask.repository;

import com.balinasoft.firsttask.domain.ImageCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageCategoryRepository extends JpaRepository<ImageCategory, Integer> {
}
