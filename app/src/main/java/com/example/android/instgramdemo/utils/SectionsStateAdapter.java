package com.example.android.instgramdemo.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectionsStateAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> list = new ArrayList<>();

    private HashMap<Fragment, Integer> mFragment = new HashMap<>();
    private HashMap<String, Integer> mFragmentNumbers = new HashMap<>();
    private HashMap<Integer, String> mFragmentName = new HashMap<>();

    public SectionsStateAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public void addFragment(Fragment fragment, String fragmentName){
        list.add(fragment);
        mFragment.put(fragment, list.size()-1);
        mFragmentNumbers.put(fragmentName, list.size()-1);
        mFragmentName.put(list.size()-1, fragmentName);
    }

    /**
     * returns fragment number with the name @param
     * @param fragmentName key to get FragmentNumber
     * @return Fragment Number
     */
    public Integer getFragmentNumber(String fragmentName){
        if (mFragmentNumbers.containsKey(fragmentName)){
            return mFragmentNumbers.get(fragmentName);
        }else {
            return null;
        }
    }


    /**
     * returns fragment number with the name @param
     * @param fragment key to get FragmentNumber
     * @return Fragment Number
     */
    public Integer getFragmentNumber(Fragment fragment){
        if (mFragment.containsKey(fragment)){
            return mFragment.get(fragment);
        }else {
            return null;
        }
    }


    /**
     * returns fragment name with the fragment number @param
     * @param fragmentNumber key to get FragmentName
     * @return Fragment Name
     */
    public String getFragmentName(Integer fragmentNumber){
        if (mFragmentName.containsKey(fragmentNumber)){
            return mFragmentName.get(fragmentNumber);
        }else {
            return null;
        }
    }




}
