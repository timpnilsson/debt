package lth.debt.Activities;


import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import lth.debt.Adapters.SectionPagerAdapter;
import lth.debt.R;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private SectionPagerAdapter sectionPagerAdapter;
    private int[] tabIconIDs = { R.drawable.ic_credit_card, R.drawable.ic_add_group, R.drawable.ic_settings_menu };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.toolbar_icon);


        viewPager = (ViewPager) findViewById(R.id.pager);
        sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(), this, tabIconIDs);
        viewPager.setAdapter(sectionPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        // Sätter custom view för alla tabs
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(sectionPagerAdapter.getTabView(i));
            updateIconColor(getResources().getColor(R.color.gray), tabLayout.getTabAt(i));
        }

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                updateIconColor(getResources().getColor(R.color.black), tab);
                viewPager.setCurrentItem(tab.getPosition());

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                updateIconColor(getResources().getColor(R.color.gray), tab);
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                updateIconColor(getResources().getColor(R.color.black), tab);
            }
        });


        //Markerar första iconen och sätter andra till omarkerade (bugg?)
        tabLayout.getTabAt(2).select();
        tabLayout.getTabAt(0).select();
    }

    private void updateIconColor(int color, TabLayout.Tab tab) {
        Drawable img = getDrawable(tabIconIDs[tab.getPosition()]);
        PorterDuff.Mode mMode = PorterDuff.Mode.SRC_ATOP;
        img.setColorFilter(color, mMode);
    }
}