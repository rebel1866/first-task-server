package com.balinasoft.firsttask.service;

import com.balinasoft.firsttask.dto.ImageCategoryDtoIn;
import com.balinasoft.firsttask.dto.ImageCategoryDtoOut;

public interface ImageCategoryService {
    ImageCategoryDtoOut addCategory(ImageCategoryDtoIn imageCategoryDtoIn);
}
