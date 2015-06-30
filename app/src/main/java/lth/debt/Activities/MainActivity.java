package lth.debt.Activities;


import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import lth.debt.Adapters.SectionPagerAdapter;
import lth.debt.R;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private SectionPagerAdapter sectionPagerAdapter;
    private ArrayList<Integer> imageResId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVars();
        setupTabLayout();
        setUpViewPager();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                updateIconColor(getResources().getColor(R.color.black), tab);
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
    }


    @Override
    public void onBackPressed() {
        if (sectionPagerAdapter.back()) {
            super.onBackPressed();
        }
    }


    private void initVars() {
        imageResId = new ArrayList<>();
        imageResId.add(R.drawable.ic_credit_card);
        imageResId.add(R.drawable.ic_add_group);
        imageResId.add(R.drawable.ic_settings_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.pager);
        sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.mipmap.toolbar_icon);
        }
    }

    private void updateIconColor(int color, TabLayout.Tab tab) {
        Drawable img = getDrawable(imageResId.get(tab.getPosition()));
        PorterDuff.Mode mMode = PorterDuff.Mode.SRC_ATOP;
        img.setColorFilter(color, mMode);
    }

    private void setupTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setIcon(imageResId.get(0)));
        tabLayout.addTab(tabLayout.newTab().setIcon(imageResId.get(1)));
        tabLayout.addTab(tabLayout.newTab().setIcon(imageResId.get(2)));
        updateIconColor(getResources().getColor(R.color.black), tabLayout.getTabAt(0));
        updateIconColor(getResources().getColor(R.color.gray), tabLayout.getTabAt(1));
        updateIconColor(getResources().getColor(R.color.gray), tabLayout.getTabAt(2));
    }

    private void setUpViewPager() {
        viewPager.setAdapter(sectionPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}