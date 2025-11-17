package br.com.pessoa.service;

import br.com.api.client.ApiClient;
import br.com.common.service.ApiServiceException;
import br.com.pessoa.dto.PessoaListResponse;
import br.com.pessoa.dto.PessoaRequest;
import br.com.pessoa.dto.PessoaResponse;

import java.io.IOException;
import java.util.List;

public class PessoaService {

    private final ApiClient apiClient;

    public PessoaService() {
        this.apiClient = new ApiClient();
    }

    public List<PessoaResponse> findPessoas() throws IOException, ApiServiceException {
        PessoaListResponse pessoaListResponse = apiClient.get("/pessoas", PessoaListResponse.class);
        return pessoaListResponse.getPessoas();
    }

    public PessoaResponse createPessoa(PessoaRequest pessoaRequest) throws IOException, ApiServiceException {
        return apiClient.post("/pessoas", pessoaRequest, PessoaResponse.class);
    }

    public PessoaResponse updatePessoa(Long id, PessoaRequest pessoaRequest) throws IOException, ApiServiceException {
        return apiClient.put("/pessoas/" + id, pessoaRequest, PessoaResponse.class);
    }

    public void deletePessoa(Long id) throws IOException, ApiServiceException {
        apiClient.delete("/pessoas/" + id);
    }
}