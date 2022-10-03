package cbtis.app.aplicacionCbtis.ui.cursos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import cbtis.app.aplicacionCbtis.PrincipalFragment;
import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.databinding.FragmentCursosBinding;
import cbtis.app.aplicacionCbtis.ui.comunidad.ComunidadFragment;
import cbtis.app.aplicacionCbtis.ui.configuraciones.ConfiguracionesFragment;
import cbtis.app.aplicacionCbtis.ui.cursos.controlador.PagerController;
import cbtis.app.aplicacionCbtis.ui.home.HogarFragment;


public class CursosFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    PagerController pagerAdapter;
    FragmentManager fragmentManager;

    public CursosFragment() {
    }

    public static CursosFragment newInstance() {
        CursosFragment fragment = new CursosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cursos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tablayout);
        viewPager2 = view.findViewById(R.id.viewPager);

        pagerAdapter = new PagerController((FragmentActivity) getContext());
        viewPager2.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition() == 1){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition() == 2){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }
}