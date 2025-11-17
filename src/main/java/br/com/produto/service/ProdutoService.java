package br.com.produto.service;

import br.com.api.client.ApiClient;
import br.com.common.service.ApiServiceException;
import br.com.produto.dto.ProdutoListResponse;
import br.com.produto.dto.ProdutoRequest;
import br.com.produto.dto.ProdutoResponse;

import java.io.IOException;
import java.util.List;

public class ProdutoService {

    private final ApiClient apiClient; // Tipo corrigido de 'errApiClient' para 'ApiClient'

    public ProdutoService() {
        this.apiClient = new ApiClient();
    }

    public List<ProdutoResponse> findProducts() throws IOException, ApiServiceException {
        ProdutoListResponse produtoListResponse = apiClient.get("/produtos", ProdutoListResponse.class);
        return produtoListResponse.getProdutos();
    }

    public ProdutoResponse createProduct(ProdutoRequest productRequest) throws IOException, ApiServiceException {
        return apiClient.post("/produtos", productRequest, ProdutoResponse.class);
    }

    public ProdutoResponse updateProduct(Long id, ProdutoRequest productRequest) throws IOException, ApiServiceException {
        return apiClient.put("/produtos/" + id, productRequest, ProdutoResponse.class);
    }

    public void deleteProduct(Long id) throws IOException, ApiServiceException {
        apiClient.delete("/produtos/" + id);
    }
}
