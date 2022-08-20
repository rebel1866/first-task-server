package com.balinasoft.firsttask.dto;

import com.balinasoft.firsttask.system.json.UnixTimestampDeserializer;
import com.balinasoft.firsttask.system.validation.InDateRange;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDtoIn {
    @NotNull
    @NotBlank
    //2 mb in base 64
    @ApiModelProperty(required = true, notes = "Base64 jpeg or png file. max 1280px (by height or width) adn 2 MiB", example = "ABC")
    @Length(max = (2 * 1024 * 1024) * 4)
    String base64Image;

    @ApiModelProperty(required = true, notes = "Unix Timestamp. 1900-01-01 - 2999-12-31", dataType = "java.lang.Long", example = "1262307723")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    @InDateRange
    Date date;

    @ApiModelProperty(required = true, allowableValues = "range[-90, 90]", notes = "Latitude")
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    double lat;

    @ApiModelProperty(required = true, allowableValues = "range[-180, 180]", notes = "Longitude")
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    double lng;

    @NotNull
    private Integer categoryId;
}
