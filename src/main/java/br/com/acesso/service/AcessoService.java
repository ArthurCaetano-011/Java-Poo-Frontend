package br.com.acesso.service;

import br.com.acesso.dto.AcessoListResponse;
import br.com.acesso.dto.AcessoRequest;
import br.com.acesso.dto.AcessoResponse;
import br.com.api.client.ApiClient;
import br.com.common.service.ApiServiceException;

import java.io.IOException;
import java.util.List;

public class AcessoService {

    private final ApiClient apiClient;

    public AcessoService() {
        this.apiClient = new ApiClient();
    }

    public List<AcessoResponse> findAcessos() throws IOException, ApiServiceException {
        AcessoListResponse acessoListResponse = apiClient.get("/acessos", AcessoListResponse.class);
        return acessoListResponse.getAcessos();
    }

    public AcessoResponse createAcesso(AcessoRequest acessoRequest) throws IOException, ApiServiceException {
        return apiClient.post("/acessos", acessoRequest, AcessoResponse.class);
    }

    public AcessoResponse updateAcesso(Long id, AcessoRequest acessoRequest) throws IOException, ApiServiceException {
        return apiClient.put("/acessos/" + id, acessoRequest, AcessoResponse.class);
    }

    public void deleteAcesso(Long id) throws IOException, ApiServiceException {
        apiClient.delete("/acessos/" + id);
    }
}