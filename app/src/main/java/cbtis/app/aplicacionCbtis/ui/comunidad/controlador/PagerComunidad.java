package cbtis.app.aplicacionCbtis.ui.comunidad.controlador;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerComunidad extends FragmentStateAdapter {
    public PagerComunidad(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ClubsFragment();
            case 1:
                return new EspecialidadesFragment();
            case 2:
                return new HorariosFragment();
            default:
                return new ClubsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
