package lth.debt.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import lth.debt.Fragments.ActionFragment;
import lth.debt.Fragments.DebtFragment;
import lth.debt.Fragments.SettingsFragment;
import lth.debt.R;

/**
 * Created by Carl on 2015-06-29.
 */
public class SectionPagerAdapter extends FragmentPagerAdapter {
    private int[] tabIconIDs;
    private Context context;

    public SectionPagerAdapter(FragmentManager fm, Context context, int[] tabIconIDs) {
        super(fm);
        this.context = context;
        this.tabIconIDs = tabIconIDs;
    }

    public View getTabView(int position) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        ImageView img = (ImageView) v.findViewById(R.id.tab_icon);
        img.setImageResource(tabIconIDs[position]);
        return v;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ActionFragment();
            case 1:
                return new DebtFragment();
            case 2:
                return new SettingsFragment();
            default:
                return new ActionFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}

