package com.example.law_ita;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class MateriaAdapter extends FirestoreRecyclerAdapter<materia, MateriaAdapter.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */

    RecyclerView recView;
    MateriaAdapter adapter;
    public MateriaAdapter(@NonNull FirestoreRecyclerOptions<materia> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull materia materia) {
        holder.txtNameM.setText("Nombre: " + materia.getNombre());
        holder.txtDescripcion.setText("Descripción: \n" + materia.getDescripcion());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_materias, viewGroup, false);

        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNameM;
        TextView txtDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameM = itemView.findViewById(R.id.txtNameM);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
        }
    }
}