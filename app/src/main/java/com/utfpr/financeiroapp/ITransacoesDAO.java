package com.utfpr.financeiroapp;


import java.util.List;

public interface ITransacoesDAO
{
    public boolean salvar(TransacoesEntity c);
    public boolean atualizar(TransacoesEntity c);
    public boolean remover(TransacoesEntity c);
    public List<TransacoesEntity> listar();
}
