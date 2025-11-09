package br.com.api.dto;

import br.com.acesso.enums.TipoAcesso;

public record LoginResponse(String token, TipoAcesso tipoAcesso) {
}