package com.example.ownroadrider;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Image_Slider_Hadong_Choi extends FragmentStateAdapter {

    public int mCount;

    public Image_Slider_Hadong_Choi(FragmentActivity fa, int count) {
        super(fa);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        if(index==0) return new Hadong_Choi_Img1();
        else if(index==1) return new Hadong_Choi_Img2();
        else if(index==2) return new Hadong_Choi_Img3();
        else return new Hadong_Choi_Img4();
    }

    @Override
    public int getItemCount() {
        return 2000;
    }

    public int getRealPosition(int position) { return position % mCount; }

}