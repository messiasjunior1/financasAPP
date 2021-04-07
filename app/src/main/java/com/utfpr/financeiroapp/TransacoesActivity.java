package com.utfpr.financeiroapp;


import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TransacoesActivity extends AppCompatActivity
{
    private RecyclerView listTransacoes;
    private List<TransacoesEntity> lista = new ArrayList<>();

    TransacoesAdapter adapter;
    AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listTransacoes = findViewById(R.id.recyclerSaldo);

        geraLista();
        //Configuração do adapter
        TransacoesAdapter adapter = new TransacoesAdapter(lista);

        //Configuração do recycler view
        //layout manager
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        listTransacoes.setLayoutManager(manager);

        //adapter
        listTransacoes.setAdapter(adapter);

        //adicionando listenes para on click
        listTransacoes.addOnItemTouchListener(new TransacoesViewTouchListener(
                getApplicationContext(), listTransacoes, new ITransacoesClickListener() {

            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), lista.get(position).getNome(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getApplicationContext(), lista.get(position).getNome(), Toast.LENGTH_SHORT).show();
            }
        }

        ));
    }

    public void geraLista(){
        lista.add(new TransacoesEntity("ABC", "1656.22", "Hotel", "Curitiba", "14/12/1997", "1"));

    }
}