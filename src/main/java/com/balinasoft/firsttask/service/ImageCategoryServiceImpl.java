package com.balinasoft.firsttask.service;

import com.balinasoft.firsttask.domain.ImageCategory;
import com.balinasoft.firsttask.dto.ImageCategoryDtoIn;
import com.balinasoft.firsttask.dto.ImageCategoryDtoOut;
import com.balinasoft.firsttask.repository.ImageCategoryRepository;
import com.balinasoft.firsttask.system.error.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        ImageCategory imageSaved = imageCategoryRepository.save(imageCategory);
        return toDto(imageSaved);
    }

    @Override
    public List<ImageCategoryDtoOut> getAllCategories() {
        List<ImageCategory> categories = imageCategoryRepository.findAll();
        if (categories.size() == 0) {
            throw new NotFoundException();
        }
        return categories.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ImageCategoryDtoOut getCategoryById(int id) {
        ImageCategory imageCategory = imageCategoryRepository.findOne(id);
        if (imageCategory == null) {
            throw new NotFoundException();
        }
        return toDto(imageCategory);
    }

    @Override
    public void deleteCategory(int id) {
        if (!imageCategoryRepository.exists(id)) {
            throw new NotFoundException();
        }
        imageCategoryRepository.delete(id);
    }

    private ImageCategoryDtoOut toDto(ImageCategory imageCategory) {
        return new ImageCategoryDtoOut(imageCategory.getImageCategoryId(), imageCategory.getCategoryName(),
                imageCategory.getCreationDate());
    }
}
