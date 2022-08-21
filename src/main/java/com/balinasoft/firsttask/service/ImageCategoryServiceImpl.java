package com.balinasoft.firsttask.service;

import com.balinasoft.firsttask.domain.ImageCategory;
import com.balinasoft.firsttask.dto.ImageCategoryDtoIn;
import com.balinasoft.firsttask.dto.ImageCategoryDtoOut;
import com.balinasoft.firsttask.repository.ImageCategoryRepository;
import com.balinasoft.firsttask.system.error.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageCategoryServiceImpl implements ImageCategoryService {

    private ImageCategoryRepository imageCategoryRepository;
    @Value("${context.pageSize}")
    private String pageSize;

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
        return convertToDto(imageSaved);
    }

    @Override
    public List<ImageCategoryDtoOut> getAllCategories(int page) {
        Page<ImageCategory> pageCategory = imageCategoryRepository.findAll(new PageRequest(page, Integer.parseInt(pageSize)));
        List<ImageCategory> categories = pageCategory.getContent();
        if (categories.size() == 0) {
            throw new NotFoundException("Nothing found");
        }
        return categories.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public ImageCategoryDtoOut getCategoryById(int id) {
        ImageCategory imageCategory = imageCategoryRepository.findOne(id);
        if (imageCategory == null) {
            throw new NotFoundException("No category found by given id: " + id);
        }
        return convertToDto(imageCategory);
    }

    @Override
    public void deleteCategory(int id) {
        if (!imageCategoryRepository.exists(id)) {
            throw new NotFoundException("No category found by given id: " + id);
        }
        imageCategoryRepository.delete(id);
    }


    private ImageCategoryDtoOut convertToDto(ImageCategory imageCategory) {
        return new ImageCategoryDtoOut(imageCategory.getImageCategoryId(), imageCategory.getCategoryName(),
                imageCategory.getCreationDate());
    }
}
