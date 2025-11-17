package br.com.api.dto;

public enum TipoContato {

    CLIENTE("Contato Cliente"),
    FORNECEDOR("Contato Fornecedor"),
    FUNCIONARIO("Contato Funcionario");

    private final String descricao;

    private TipoContato(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
