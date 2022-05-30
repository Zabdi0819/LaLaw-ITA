package com.example.law_ita;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link materiasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class materiasFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View MateriaView;
    private RecyclerView materiaList;
    MateriaAdapter adapter;

    public materiasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment materiasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static materiasFragment newInstance(String param1, String param2) {
        materiasFragment fragment = new materiasFragment();
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
        MateriaView = inflater.inflate(R.layout.fragment_materias, container, false);
        materiaList = (RecyclerView) MateriaView.findViewById(R.id.recyclerMaterias);
        materiaList.setLayoutManager(new LinearLayoutManager(getContext()));

        FirestoreRecyclerOptions<materia> options =
                new FirestoreRecyclerOptions.Builder<materia>()
                        .setQuery(FirebaseFirestore.getInstance().collection("materias")
                                , materia.class).build();

        adapter = new MateriaAdapter(options);
        materiaList.setAdapter(adapter);

        return MateriaView;
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