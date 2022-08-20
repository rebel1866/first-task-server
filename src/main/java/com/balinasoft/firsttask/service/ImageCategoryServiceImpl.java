package com.balinasoft.firsttask.service;

import com.balinasoft.firsttask.domain.ImageCategory;
import com.balinasoft.firsttask.dto.ImageCategoryDtoIn;
import com.balinasoft.firsttask.dto.ImageCategoryDtoOut;
import com.balinasoft.firsttask.repository.ImageCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ImageCategoryServiceImpl implements ImageCategoryService {

    private ImageCategoryRepository imageCategoryRepository;

    @Autowired
    public void setImageCategoryRepository(ImageCategoryRepository imageCategoryRepository) {
        this.imageCategoryRepository = imageCategoryRepository;
    }

    @Override
    public ImageCategoryDtoOut addCategory(ImageCategoryDtoIn imageCategoryDtoIn) {
        ImageCategory imageCategory = new ImageCategory();
        imageCategory.setCategoryName(imageCategoryDtoIn.getName());
        imageCategory.setCreationDate(LocalDateTime.now());
        ImageCategory saved = imageCategoryRepository.save(imageCategory);
        return new ImageCategoryDtoOut(saved.getImageCategoryId(), saved.getCategoryName(), saved.getCreationDate());
    }
}
