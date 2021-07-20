package com.calistasakralya.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.calistasakralya.fragment.PageFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private final String id;

    public final String[] mFragmentNames = new String[] {//Tabs names array
            "Trip 2 Hari 1 Malam",
            "Trip 1 Hari"
    };

    public ViewPagerAdapter(FragmentActivity fa, String id){//Pager constructor receives Activity instance
        super(fa);
        this.id = id;
    }

    @Override
    public int getItemCount() {
        return mFragmentNames.length;//Number of fragments displayed
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return PageFragment.newInstance(id, 2-position);
    }
}
