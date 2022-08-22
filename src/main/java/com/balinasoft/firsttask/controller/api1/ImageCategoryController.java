package com.balinasoft.firsttask.controller.api1;

import com.balinasoft.firsttask.dto.ImageCategoryDtoIn;
import com.balinasoft.firsttask.dto.ImageDtoOut;
import com.balinasoft.firsttask.dto.ResponseDto;
import com.balinasoft.firsttask.service.ImageCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.balinasoft.firsttask.system.StaticWrapper.wrap;

@RestController
@RequestMapping("/api/category")
@Secured("ROLE_USER")
@Api(tags = "Image categories")
public class ImageCategoryController {
    private ImageCategoryService imageCategoryService;

    @Autowired
    public void setImageCategoryService(ImageCategoryService imageCategoryService) {
        this.imageCategoryService = imageCategoryService;
    }


    @PostMapping
    @ApiOperation(value = "Add image category")
    public ResponseDto addImageCategory(@RequestBody @Valid ImageCategoryDtoIn imageCategoryDtoIn) {
        return wrap(imageCategoryService.addCategory(imageCategoryDtoIn));
    }

    @GetMapping
    @ApiOperation(value = "Get all categories")
    public ResponseDto getAllCategories(@RequestParam(value = "page", defaultValue = "0") int page) {
        return wrap(imageCategoryService.getAllCategories(page));
    }


    @GetMapping(value = ("/{id}"))
    @ApiOperation(value = "Get category by id")
    public ResponseDto getCategoryById(@PathVariable int id) {
        return wrap(imageCategoryService.getCategoryById(id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete image category")
    public void deleteCategory(@PathVariable int id) {
        imageCategoryService.deleteCategory(id);
    }
}
