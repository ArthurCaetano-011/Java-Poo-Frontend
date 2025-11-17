package br.com.preco.dto;

import br.com.preco.enums.TipoPreco;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record PrecoRequest(
    BigDecimal valor,
    LocalDate dataAlteracao,
    LocalTime horaAlteracao,
    Long produtoId
) {}
