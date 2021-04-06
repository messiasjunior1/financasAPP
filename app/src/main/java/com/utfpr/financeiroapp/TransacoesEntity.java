package com.utfpr.financeiroapp;

import java.io.Serializable;
import java.util.Date;

public class  TransacoesEntity implements Serializable
{
    private Long id;
    private String nome;
    private String valor;
    private String descricao;
    private String local;
    private String data;
    private String tipoTransacoes;

    private String Despesa = "1";
    private String Saldo = "2";

    public TransacoesEntity(String nome, String valor, String descricao, String local, String data, String tipoTransacoes)
    {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.local = local;
        this.data = data;
        this.tipoTransacoes = tipoTransacoes;
    }

    public Long getId() { return id; }

    public String getNome() { return nome; }

    public String getValor() { return valor; }

    public String getDescricao() { return descricao; }

    public String getLocal() { return local; }

    public String getData() { return data; }

    public String getTipoTransacoes() { return tipoTransacoes; }

    public void setId(Long id) { this.id = id; }

    public void setNome(String nome) { this.nome = nome; }

    public void setValor(String valor) { this.valor = valor; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public void setLocal(String local) { this.local = local; }

    public void setData(String data) { this.data = data; }

    public void setTipoTransacoes(String tipoTransacoes) { this.tipoTransacoes = tipoTransacoes; }
}