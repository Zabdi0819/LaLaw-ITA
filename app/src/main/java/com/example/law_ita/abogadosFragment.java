package com.example.law_ita;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link abogadosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class abogadosFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View AbogadosView;
    private RecyclerView abogadosList;
    AbogadosAdapter adapter;

    public abogadosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment abogadosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static abogadosFragment newInstance(String param1, String param2) {
        abogadosFragment fragment = new abogadosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        AbogadosView = inflater.inflate(R.layout.fragment_abogados, container, false);
        abogadosList = (RecyclerView) AbogadosView.findViewById(R.id.recyclerAbogados);
        abogadosList.setLayoutManager(new LinearLayoutManager(getContext()));

        FirestoreRecyclerOptions<abogado> options =
                new FirestoreRecyclerOptions.Builder<abogado>()
                        .setQuery(FirebaseFirestore.getInstance().collection("abogados")
                                , abogado.class).build();

        adapter = new AbogadosAdapter(options);
        abogadosList.setAdapter(adapter);

        return AbogadosView;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
        //FirestoreRecyclerOptions<Chat> options = new FirestoreRecyclerOptions.Builder<Chat>()
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.startListening();
        //FirestoreRecyclerOptions<Chat> options = new FirestoreRecyclerOptions.Builder<Chat>()
    }
}