package br.com.api.dto;

import com.google.gson.annotations.SerializedName;

public record LoginRequest(
        @SerializedName("usuario") String username,
        @SerializedName("senha") String password
) {
}