package com.balinasoft.firsttask.service;

import com.balinasoft.firsttask.dto.ImageCategoryDtoIn;
import com.balinasoft.firsttask.dto.ImageCategoryDtoOut;
import com.balinasoft.firsttask.dto.ImageDtoOut;

import java.util.List;

public interface ImageCategoryService {
    ImageCategoryDtoOut addCategory(ImageCategoryDtoIn imageCategoryDtoIn);

    List<ImageCategoryDtoOut> getAllCategories(int page);

    ImageCategoryDtoOut getCategoryById(int id);

    void deleteCategory(int id);

}
