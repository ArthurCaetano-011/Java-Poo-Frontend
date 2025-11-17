package br.com.preco.dto;

import com.google.gson.annotations.JsonAdapter; // Importar JsonAdapter
import br.com.common.service.LocalTimeAdapter; // Importar LocalTimeAdapter

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record PrecoResponse(
        Long id,
        BigDecimal valor,
        LocalDate dataAlteracao,
        @JsonAdapter(LocalTimeAdapter.class) // Anotação para forçar o uso do adaptador
        LocalTime horaAlteracao,
        Long produtoId
) {}
