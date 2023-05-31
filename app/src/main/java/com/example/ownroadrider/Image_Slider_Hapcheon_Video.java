package com.example.ownroadrider;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Image_Slider_Hapcheon_Video extends FragmentStateAdapter {

    public int mCount;

    public Image_Slider_Hapcheon_Video(FragmentActivity fa, int count) {
        super(fa);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        if(index==0) return new Hapcheon_Video_Img1();
        else if(index==1) return new Hapcheon_Video_Img2();
        else if(index==2) return new Hapcheon_Video_Img3();
        else return new Hapcheon_Video_Img4();
    }

    @Override
    public int getItemCount() {
        return 2000;
    }

    public int getRealPosition(int position) { return position % mCount; }

}