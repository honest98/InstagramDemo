package com.example.android.instgramdemo.utils;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.android.instgramdemo.likes.LikesActivity;
import com.example.android.instgramdemo.share.ShareActivity;
import com.example.android.instgramdemo.home.HomeActivity;
import com.example.android.instgramdemo.profile.ProfileActivity;
import com.example.android.instgramdemo.R;
import com.example.android.instgramdemo.search.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {
        bottomNavigationViewEx.enableAnimation(true);
        bottomNavigationViewEx.enableItemShiftingMode(true);
        bottomNavigationViewEx.enableShiftingMode(true);
        bottomNavigationViewEx.setTextVisibility(false);

    }

    public static void enableNavigation(final Context context,BottomNavigationViewEx viewEx) {
        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.ic_home:
                        context.startActivity(new Intent(context,HomeActivity.class));
                        break;

                    case R.id.ic_search:
                        context.startActivity(new Intent(context,SearchActivity.class));
                        break;

                    case R.id.ic_circle:
                        context.startActivity(new Intent(context,ShareActivity.class));
                        break;

                    case R.id.ic_alert:
                        context.startActivity(new Intent(context,LikesActivity.class));
                        break;

                    case R.id.ic_profile:
                        context.startActivity(new Intent(context,ProfileActivity.class));
                        break;
                }
                return false;
            }
        });
    }
}
