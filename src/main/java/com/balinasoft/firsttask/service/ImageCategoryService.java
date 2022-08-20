package com.balinasoft.firsttask.service;

import com.balinasoft.firsttask.dto.ImageCategoryDtoIn;
import com.balinasoft.firsttask.dto.ImageCategoryDtoOut;

import java.util.List;

public interface ImageCategoryService {
    ImageCategoryDtoOut addCategory(ImageCategoryDtoIn imageCategoryDtoIn);

    List<ImageCategoryDtoOut> getAllCategories();

    ImageCategoryDtoOut getCategoryById(int id);
}
