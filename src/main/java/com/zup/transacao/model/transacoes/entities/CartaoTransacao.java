package com.zup.transacao.model.transacoes.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.zup.transacao.model.transacoes.response.CartaoResponse;

@Entity
public class CartaoTransacao {

    @Id
    public String id;
    @NotNull
    public String email;
    @OneToOne
    public Transacoes transacao;

    @Deprecated
    public CartaoTransacao(){}

    public CartaoTransacao(String id, String email, Transacoes transacao) {
        this.id = id;
        this.email = email;
        this.transacao = transacao;
    }

    public CartaoTransacao(CartaoResponse cartaoResponse, Transacoes transacao) {
        this.id = cartaoResponse.getId();
        this.email = cartaoResponse.getEmail();
        this.transacao = transacao;
    }

    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public Transacoes getTransacao() {
        return this.transacao;
    }

}
