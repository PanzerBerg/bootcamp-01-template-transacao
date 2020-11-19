package com.zup.transacao.model.transacoes.response;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import com.zup.transacao.model.transacoes.entities.Transacoes;

public class TransacoesResponse {
    
    public String id;
    public Double valor;
    public EstabelecimentoResponse estabelecimento;
    public CartaoResponse cartao;
    public LocalDateTime efetivadaEm;

    @Deprecated
    public TransacoesResponse(){}

    public TransacoesResponse(String id, Double valor, EstabelecimentoResponse estabelecimento, CartaoResponse cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return this.id;
    }

    public Double getValor() {
        return this.valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return this.estabelecimento;
    }

    public CartaoResponse getCartao() {
        return this.cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return this.efetivadaEm;
    }

    public Transacoes toEntity(EntityManager manager) {
        return new Transacoes(this.id, this.valor, this.estabelecimento, this.cartao, this.efetivadaEm);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", valor='" + getValor() + "'" +
            ", estabelecimento='" + getEstabelecimento().toString() + "'" +
            ", cartao='" + getCartao().toString() + "'" +
            ", efetivadaEm='" + getEfetivadaEm() + "'" +
            "}";
    }

}
