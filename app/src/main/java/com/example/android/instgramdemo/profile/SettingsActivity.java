package com.example.android.instgramdemo.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.android.instgramdemo.R;
import com.example.android.instgramdemo.utils.BottomNavigationViewHelper;
import com.example.android.instgramdemo.utils.SectionsStateAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

   private ImageView backImageView;
   private ViewPager mViewPager;
   private RelativeLayout mRelativeLayout;
   private SectionsStateAdapter fragmentAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);


        mViewPager = findViewById(R.id.container);
        mRelativeLayout = findViewById(R.id.settingRellayout1);
        backImageView = findViewById(R.id.backArrow);
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });

        bottomNavigationView();
        setupSettingsList();
        setupFragments();

    }


    private void bottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);

        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);

        BottomNavigationViewHelper.enableNavigation(this,bottomNavigationViewEx);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);
    }

    private void setupSettingsList(){

        ListView listView = findViewById(R.id.lvAccountSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile_fragment));
        options.add(getString(R.string.sign_out_fragment));

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int position,long id) {
                setupViewPager(position);
            }
        });

    }

    private void setupFragments(){
        fragmentAdapter = new SectionsStateAdapter(getSupportFragmentManager());
        fragmentAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile_fragment)); // index 0
        fragmentAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out_fragment)); // index 1
    }

    private void setupViewPager(int fragmentNumber){

        mRelativeLayout.setVisibility(View.GONE);
        mViewPager.setAdapter(fragmentAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
    }


}
