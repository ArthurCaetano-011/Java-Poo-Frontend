package br.com.preco.service;

import br.com.common.http.PageResponse;
import br.com.common.service.ApiServiceException;
import br.com.preco.dto.PrecoRequest;
import br.com.preco.dto.PrecoResponse;
import com.google.gson.reflect.TypeToken;
import br.com.api.client.ApiClient;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class PrecoService {

    private final ApiClient apiClient;

    public PrecoService() {
        this.apiClient = new ApiClient();
    }

    public List<PrecoResponse> findPrecos() throws IOException, ApiServiceException {
        // Define o tipo de resposta como uma página de PrecoResponse
        Type responseType = new TypeToken<PageResponse<PrecoResponse>>() {}.getType();
        
        // Faz a chamada à API
        PageResponse<PrecoResponse> pageResponse = apiClient.get("/precos", responseType);
        
        // Retorna apenas a lista de conteúdo de dentro da página
        return pageResponse.getContent();
    }

    public PrecoResponse findPrecoById(Long id) throws IOException, ApiServiceException {
        return apiClient.get("/precos/" + id, PrecoResponse.class);
    }

    public PrecoResponse createPreco(PrecoRequest precoRequest) throws IOException, ApiServiceException {
        return apiClient.post("/precos", precoRequest, PrecoResponse.class);
    }

    public PrecoResponse updatePreco(Long id, PrecoRequest precoRequest) throws IOException, ApiServiceException {
        return apiClient.put("/precos/" + id, precoRequest, PrecoResponse.class);
    }
}
