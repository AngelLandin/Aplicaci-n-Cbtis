package cbtis.app.aplicacionCbtis.ui.comunidad.controlador;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cbtis.app.aplicacionCbtis.R;


public class EspecialidadesFragment extends Fragment {

    public EspecialidadesFragment() {
        // Required empty public constructor
    }

    public static EspecialidadesFragment newInstance() {
        EspecialidadesFragment fragment = new EspecialidadesFragment();
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
        return inflater.inflate(R.layout.fragment_especialidades, container, false);
    }
}