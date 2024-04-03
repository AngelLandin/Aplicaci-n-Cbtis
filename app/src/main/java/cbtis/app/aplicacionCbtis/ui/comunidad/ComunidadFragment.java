package cbtis.app.aplicacionCbtis.ui.comunidad;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.comunidad.controlador.PagerComunidad;

public class ComunidadFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private PagerComunidad pagerComunidad;

    public ComunidadFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ComunidadFragment newInstance() {
        ComunidadFragment fragment = new ComunidadFragment();
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
        return inflater.inflate(R.layout.fragment_comunidad, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout = view.findViewById(R.id.tabComunidad);
        viewPager2 = view.findViewById(R.id.viewPagerComunidad);

        pagerComunidad = new PagerComunidad((FragmentActivity) getContext());
        viewPager2.setAdapter(pagerComunidad);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
                pagerComunidad.notifyItemChanged(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

    }
}