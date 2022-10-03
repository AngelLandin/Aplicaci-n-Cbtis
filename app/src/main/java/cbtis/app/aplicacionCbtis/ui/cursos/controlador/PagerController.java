package cbtis.app.aplicacionCbtis.ui.cursos.controlador;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerController extends FragmentStateAdapter{
    public PagerController(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new CursosFragment();
            case 1:
                return new GuiasFragment();
            case 2:
                return new LibrosFragment();
            default:
                return new CursosFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}