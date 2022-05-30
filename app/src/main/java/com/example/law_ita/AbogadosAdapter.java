package com.example.law_ita;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class AbogadosAdapter extends FirestoreRecyclerAdapter<abogado, AbogadosAdapter.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */

    RecyclerView recView;
    AbogadosAdapter adapter;
    public AbogadosAdapter(@NonNull FirestoreRecyclerOptions<abogado> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull abogado abogado) {
        holder.txtName.setText("Nombre: " + abogado.getNombre());
        holder.txtPhone.setText("Teléfono: " + abogado.getTelefono());
        holder.txtEmail.setText("Email: " + abogado.getEmail());
        holder.txtAddress.setText("Domicilio: " + abogado.getDomicilio());
        holder.txtS.setText("Materias: " + abogado.getEspecialidades());

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_abogados, viewGroup, false);

        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtPhone;
        TextView txtEmail;
        TextView txtAddress;
        TextView txtS;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            txtS = itemView.findViewById(R.id.txtS);

        }
    }
}
