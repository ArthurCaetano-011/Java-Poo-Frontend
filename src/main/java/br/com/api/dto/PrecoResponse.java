package br.com.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PrecoResponse(
        BigDecimal valor,
        LocalDate dataAlteracao,
        LocalDate horaAlteracao,
        TipoPreco tipoPreco
) {

}
