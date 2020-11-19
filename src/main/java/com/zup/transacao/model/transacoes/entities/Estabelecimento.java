package com.zup.transacao.model.transacoes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.zup.transacao.model.transacoes.response.EstabelecimentoResponse;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Estabelecimento {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    public String id;
    @NotNull
    public String nome;
    @NotNull
    public String cidade;
    @NotNull
    public String endereco;
    @NotNull @OneToOne
    public Transacoes transacao;

    @Deprecated
    public Estabelecimento(){}

    public Estabelecimento(String nome, String cidade, String endereco, Transacoes transacao) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
        this.transacao = transacao;
    }

    public Estabelecimento(EstabelecimentoResponse estabelecimentoResponse, Transacoes transacao) {
        this.nome = estabelecimentoResponse.getNome();
        this.cidade = estabelecimentoResponse.getCidade();
        this.endereco = estabelecimentoResponse.getEndereco();
        this.transacao = transacao;
    }

    public String getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getEndereco() {
        return this.endereco;
    }

}
