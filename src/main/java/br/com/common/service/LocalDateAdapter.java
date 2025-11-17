package br.com.common.service;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException; // Importar DateTimeParseException

public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    // Usar um formatador com padrão explícito para garantir o formato YYYY-MM-DD
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(FORMATTER.format(src));
    }

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String jsonString = json.getAsString();
        try {
            return LocalDate.parse(jsonString, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new JsonParseException("Não foi possível desserializar LocalDate: " + jsonString + ". Formato esperado: yyyy-MM-dd", e);
        }
    }
}