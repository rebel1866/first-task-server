package com.balinasoft.firsttask.dto;

import com.balinasoft.firsttask.util.JsonDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageCategoryDtoOut {
    private Integer id;
    private String name;
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDateTime creationDate;
}
