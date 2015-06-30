package lth.debt.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import lth.debt.Fragments.ActionFragment;
import lth.debt.Fragments.DebtFragment;
import lth.debt.Fragments.SettingsFragment;

/**
 * Created by Carl on 2015-06-29.
 */
public class SectionPagerAdapter extends FragmentPagerAdapter {

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
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

                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public boolean back() {
        return true;
        }

}