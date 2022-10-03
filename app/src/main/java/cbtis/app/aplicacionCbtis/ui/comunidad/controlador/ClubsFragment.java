package cbtis.app.aplicacionCbtis.ui.comunidad.controlador;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cbtis.app.aplicacionCbtis.R;


public class ClubsFragment extends Fragment {

    public ClubsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ClubsFragment newInstance(String param1, String param2) {
        ClubsFragment fragment = new ClubsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clubs, container, false);
    }
}