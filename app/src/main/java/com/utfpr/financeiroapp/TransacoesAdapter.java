package com.utfpr.financeiroapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransacoesAdapter extends RecyclerView.Adapter<TransacoesAdapter.ViewHolder>
{
    private List<TransacoesEntity> lista;

    public TransacoesAdapter(List<TransacoesEntity> lista) {
        this.lista = lista;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textNome;
        private TextView textValor;
        private TextView textDescricao;
        private TextView textLocal;
        private TextView textData;
        private TextView textTipo;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            // textNome = view.findViewById(R.id.textViewNomeCampus);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_saldos, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TransacoesEntity c = lista.get(position);

        holder.textNome.setText(c.getNome());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
