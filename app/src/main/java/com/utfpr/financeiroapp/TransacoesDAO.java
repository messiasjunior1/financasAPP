package com.utfpr.financeiroapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TransacoesDAO implements ITransacoesDAO
{

    SQLiteDatabase writer;
    SQLiteDatabase reader;

    public TransacoesDAO(Context context) {
        DBHelper db = new DBHelper(context);
        writer = db.getWritableDatabase();
        reader = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(TransacoesEntity c) {

        ContentValues cv = new ContentValues();
        cv.put(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_NOME, c.getNome());
        cv.put(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_VALOR, c.getValor());
        cv.put(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_DESCRICAO, c.getDescricao());
        cv.put(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_DATA, c.getData());
        cv.put(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_LOCAL, c.getLocal());
        cv.put(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_TIPOTRANSACOES, c.getLocal());

        try {
            writer.insert(TransacoesContract.TransacoesEntry.TABLE_NAME, null, cv);
            Log.i("DB INFO", "Campus salvo com sucesso");
        }catch (Exception e){
            Log.e("DB ERROR", "Erro ao salvar Campus" + e.getMessage());
            return false;
        }

        return false;
    }

    @Override
    public boolean atualizar(TransacoesEntity c) {

        ContentValues cv = new ContentValues();
        cv.put(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_NOME, c.getNome());
        cv.put(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_VALOR, c.getValor());
        cv.put(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_DESCRICAO, c.getDescricao());
        cv.put(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_DATA, c.getData());
        cv.put(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_LOCAL, c.getLocal());
        cv.put(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_TIPOTRANSACOES, c.getLocal());

        try {
            String[] args = {c.getId().toString()};
            writer.update(TransacoesContract.TransacoesEntry.TABLE_NAME, cv, TransacoesContract.TransacoesEntry._ID+"=?", args);
            Log.i("DB INFO", "Campus atualizado com sucesso");
        }catch (Exception e){
            Log.e("DB ERROR", "Erro ao atualizar Campus" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean remover(TransacoesEntity c) {

        try {
            String[] args = {c.getId().toString()};
            writer.delete(TransacoesContract.TransacoesEntry.TABLE_NAME, TransacoesContract.TransacoesEntry._ID+"=?", args);
            Log.i("DB INFO", "Campus deletado com sucesso");
        }catch (Exception e){
            Log.e("DB ERROR", "Erro ao deletar Campus" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<TransacoesEntity> listar() {

        List<TransacoesEntity> campus = new ArrayList<>();

        String sql = "SELECT * FROM " + TransacoesContract.TransacoesEntry.TABLE_NAME + " ;";
        Cursor cursor = reader.rawQuery(sql, null);

        while (cursor.moveToNext()){

            Long id = cursor.getLong(cursor.getColumnIndex(TransacoesContract.TransacoesEntry._ID));
            String nome = cursor.getString(cursor.getColumnIndex(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_NOME));
            String valor = cursor.getString(cursor.getColumnIndex(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_VALOR));
            String descricao = cursor.getString(cursor.getColumnIndex(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_DESCRICAO));
            String local = cursor.getString(cursor.getColumnIndex(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_LOCAL));
            String data = cursor.getString(cursor.getColumnIndex(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_DATA));
            String tipoTransacoes = cursor.getString(cursor.getColumnIndex(TransacoesContract.TransacoesEntry.COLUMN_TRANSACOES_TIPOTRANSACOES));

            TransacoesEntity c = new TransacoesEntity(nome, valor, descricao, local, data, tipoTransacoes);
            c.setId(id);

            campus.add(c);
            Log.i("TransacoesDAO", c.getNome());
        }

        return campus;
    }
}
