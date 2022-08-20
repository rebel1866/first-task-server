package com.balinasoft.firsttask.controller.api1;

import com.balinasoft.firsttask.dto.ImageCategoryDtoIn;
import com.balinasoft.firsttask.dto.ResponseDto;
import com.balinasoft.firsttask.service.ImageCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseDto addImageCategory(@RequestBody @Valid ImageCategoryDtoIn imageCategoryDtoIn) {
        return wrap(imageCategoryService.addCategory(imageCategoryDtoIn));
    }

    @Secured("ROLE_USER")
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDto getAllCategories() {
        return wrap(imageCategoryService.getAllCategories());
    }

    @Secured("ROLE_USER")
    @GetMapping(value = ("/{id}"), produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDto getCategoryById(@PathVariable int id) {
        return wrap(imageCategoryService.getCategoryById(id));
    }
}
