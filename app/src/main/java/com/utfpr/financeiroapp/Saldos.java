package com.utfpr.financeiroapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.utfpr.financeiroapp.adapter.AdapterSaldo;
import com.utfpr.financeiroapp.listener.RecyclerView.RecyclerViewClickListener;
import com.utfpr.financeiroapp.listener.RecyclerView.RecyclerViewTouchListener;

import java.util.ArrayList;
import java.util.List;

    public class Saldos extends AppCompatActivity {
    private RecyclerView listSaldo;
    private List<TransacoesEntity> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listSaldo = findViewById(R.id.recyclerSaldo);

        geraLista();
        //Configuração do adapter
        AdapterSaldo adapter = new AdapterSaldo(lista);

        //Configuração do recycler view
        //layout manager
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        listSaldo.setLayoutManager(manager);

        //adapter
        listSaldo.setAdapter(adapter);

        //adicionando listenes para on click
        listSaldo.addOnItemTouchListener(new RecyclerViewTouchListener(
                getApplicationContext(), listSaldo, new RecyclerViewClickListener() {

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
}