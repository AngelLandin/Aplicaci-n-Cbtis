package cbtis.app.aplicacionCbtis.ui.configuraciones;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cbtis.app.aplicacionCbtis.R;

public class ConfiguracionesFragment extends Fragment {

    public ConfiguracionesFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ConfiguracionesFragment newInstance(String param1, String param2) {
        ConfiguracionesFragment fragment = new ConfiguracionesFragment();
        Bundle args = new Bundle();
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
        return inflater.inflate(R.layout.fragment_configuraciones, container, false);
    }
}