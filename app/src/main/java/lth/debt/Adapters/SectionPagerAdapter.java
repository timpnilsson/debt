package lth.debt.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;

import lth.debt.Fragments.ActionFragment;
import lth.debt.Fragments.DebtFragment;
import lth.debt.R;
import lth.debt.Fragments.SettingsFragment;

/**
 * Created by Carl on 2015-06-29.
 */
public class SectionPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private int[] imageResId = {
            R.drawable.ic_credit_card,
            R.drawable.ic_add_group,
            R.drawable.ic_settings_menu
    };

    private String[] titles = {
            "Actions",
            "Debt",
            "Profile"
    };

    public SectionPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context=context;

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

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable image = context.getDrawable(imageResId[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth()+44, image.getIntrinsicHeight()+44);
        Log.d("h", String.valueOf(image.getIntrinsicHeight()));
        SpannableString sb = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(image);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
}