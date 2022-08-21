package com.balinasoft.firsttask.dto;

import com.balinasoft.firsttask.system.json.UnixTimestampSereliazer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDtoOut {

    @ApiModelProperty(required = true)
    int id;

    @ApiModelProperty(required = true)
    String url;

    @ApiModelProperty(required = true, dataType = "java.lang.Long", example = "1262307723")
    @JsonSerialize(using = UnixTimestampSereliazer.class)
    Date date;

    @ApiModelProperty(required = true)
    double lat;

    @ApiModelProperty(required = true)
    double lng;

    private ImageCategoryDtoOut imageCategory;
}
