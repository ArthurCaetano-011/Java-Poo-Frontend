package br.com.common.service;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME; // Mais flexível

    @Override
    public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(FORMATTER.format(src));
    }

    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String jsonString = json.getAsString();
        try {
            return LocalDateTime.parse(jsonString, FORMATTER);
        } catch (java.time.format.DateTimeParseException e) {
            TemporalAccessor parsed = DateTimeFormatter.ISO_OFFSET_DATE_TIME.parseBest(jsonString, LocalDateTime::from, java.time.OffsetDateTime::from);
            if (parsed instanceof LocalDateTime) {
                return (LocalDateTime) parsed;
            } else if (parsed instanceof java.time.OffsetDateTime) {
                return ((java.time.OffsetDateTime) parsed).toLocalDateTime();
            }
            throw new JsonParseException("Não foi possível desserializar LocalDateTime: " + jsonString, e);
        }
    }
}
