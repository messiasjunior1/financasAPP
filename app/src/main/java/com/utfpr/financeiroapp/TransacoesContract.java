package com.utfpr.financeiroapp;

import android.provider.BaseColumns;

public final class TransacoesContract
{

    private TransacoesContract() {}

    public static class TransacoesEntry implements BaseColumns {
        public static final String TABLE_NAME = "transacoes";
        public static final String COLUMN_TRANSACOES_NOME = "usuario";
        public static final String COLUMN_TRANSACOES_VALOR = "valor";
        public static final String COLUMN_TRANSACOES_DESCRICAO = "descricao";
        public static final String COLUMN_TRANSACOES_LOCAL = "local";
        public static final String COLUMN_TRANSACOES_DATA = "data";
        public static final String COLUMN_TRANSACOES_TIPOTRANSACOES = "tipoTransacoes";
    }
}
