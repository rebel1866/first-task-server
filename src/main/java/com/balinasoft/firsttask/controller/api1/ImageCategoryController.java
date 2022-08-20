package com.balinasoft.firsttask.controller.api1;

import com.balinasoft.firsttask.dto.ImageCategoryDtoIn;
import com.balinasoft.firsttask.dto.ResponseDto;
import com.balinasoft.firsttask.service.ImageCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.balinasoft.firsttask.system.StaticWrapper.wrap;

@RestController
@RequestMapping("/api/image/category")
@Secured("ROLE_USER")
public class ImageCategoryController {
    private ImageCategoryService imageCategoryService;

    @Autowired
    public void setImageCategoryService(ImageCategoryService imageCategoryService) {
        this.imageCategoryService = imageCategoryService;
    }


    @PostMapping
    public ResponseDto addImageCategory(@RequestBody @Valid ImageCategoryDtoIn imageCategoryDtoIn) {
        return wrap(imageCategoryService.addCategory(imageCategoryDtoIn));
    }

    @GetMapping
    public ResponseDto getAllCategories(@RequestParam(value = "page", defaultValue = "0") int page) {
        return wrap(imageCategoryService.getAllCategories(page));
    }


    @GetMapping(value = ("/{id}"))
    public ResponseDto getCategoryById(@PathVariable int id) {
        return wrap(imageCategoryService.getCategoryById(id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id) {
        //TODO 1)secured only particular user id
        // 2) swagger
        // 4) optional ?
        imageCategoryService.deleteCategory(id);
    }
}
