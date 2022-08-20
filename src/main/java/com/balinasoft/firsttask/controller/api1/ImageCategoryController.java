package com.balinasoft.firsttask.controller.api1;

import com.balinasoft.firsttask.dto.ImageCategoryDtoIn;
import com.balinasoft.firsttask.dto.ResponseDto;
import com.balinasoft.firsttask.service.ImageCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.balinasoft.firsttask.system.StaticWrapper.wrap;

@RestController
@RequestMapping("/api/image-category")
public class ImageCategoryController {
    private ImageCategoryService imageCategoryService;

    @Autowired
    public void setImageCategoryService(ImageCategoryService imageCategoryService) {
        this.imageCategoryService = imageCategoryService;
    }

    @Secured("ROLE_USER")
    @RequestMapping( method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDto addImageCategory(@RequestBody @Valid ImageCategoryDtoIn imageCategoryDtoIn) {
        return wrap(imageCategoryService.addCategory(imageCategoryDtoIn));
    }
}
