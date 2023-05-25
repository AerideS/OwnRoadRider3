package com.example.ownroadrider;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Image_Slider_Geoje_Blackrock extends FragmentStateAdapter {

    public int mCount;

    public Image_Slider_Geoje_Blackrock(FragmentActivity fa, int count) {
        super(fa);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        if (index == 0) return new Geoje_Blackrock_Img1();
        else if (index == 1) return new Geoje_Blackrock_Img2();
        else if (index == 2) return new Geoje_Blackrock_Img3();
        else return new Geoje_Blackrock_Img4();
    }

    @Override
    public int getItemCount() {
        return 2000;
    }

    public int getRealPosition(int position) {
        return position % mCount;
    }
}