package com.zup.transacao.model.transacoes.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.zup.transacao.model.transacoes.response.CartaoResponse;
import com.zup.transacao.model.transacoes.response.EstabelecimentoResponse;

@Entity
public class Transacoes {
    
    @Id
    public String id;
    @Positive @NotNull
    public Double valor;
    @NotNull @ManyToOne(cascade = CascadeType.ALL)
    public Estabelecimento estabelecimento;
    @NotNull @ManyToOne(cascade = CascadeType.ALL)
    public CartaoTransacao cartao;
    @NotNull
    public LocalDateTime efetivadaEm;

    @Deprecated
    public Transacoes(){}

    public Transacoes(String id, Double valor, EstabelecimentoResponse estabelecimento, CartaoResponse cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = new Estabelecimento(estabelecimento, this);
        this.cartao = new CartaoTransacao(cartao, this);
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return this.id;
    }

    public Double getValor() {
        return this.valor;
    }

    public Estabelecimento getEstabelecimento() {
        return this.estabelecimento;
    }

    public CartaoTransacao getCartao() {
        return this.cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return this.efetivadaEm;
    }
    
}
