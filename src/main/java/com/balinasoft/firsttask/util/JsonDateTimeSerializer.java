package com.balinasoft.firsttask.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.time.LocalDateTime;

@NoArgsConstructor
public class JsonDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime date, JsonGenerator generator, SerializerProvider arg) throws IOException {
        final String dateString = date.toString();
        generator.writeString(dateString);
    }
}