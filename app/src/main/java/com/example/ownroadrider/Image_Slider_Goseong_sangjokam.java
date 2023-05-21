package com.example.ownroadrider;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Image_Slider_Goseong_sangjokam extends FragmentStateAdapter {

    public int mCount;

    public Image_Slider_Goseong_sangjokam(FragmentActivity fa, int count) {
        super(fa);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        if(index==0) return new Goseong_Sangjokam_img1();
        else if(index==1) return new Goseong_Sangjokam_img2();
        else if(index==2) return new Goseong_Sangjokam_img3();
        else return new Goseong_Sangjokam_img4();
    }

    @Override
    public int getItemCount() {
        return 2000;
    }

    public int getRealPosition(int position) { return position % mCount; }

}