package com.zup.transacao.model.transacoes.response;

public class CartaoResponse {
    
    public String id;
    public String email;

    @Deprecated
    public CartaoResponse() {}

    public CartaoResponse(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }

}
