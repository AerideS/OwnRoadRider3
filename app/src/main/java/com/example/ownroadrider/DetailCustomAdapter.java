package com.example.ownroadrider;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DetailCustomAdapter extends RecyclerView.Adapter<DetailCustomAdapter.ViewHolder> {
    private List<CardForDetailSchedule> dataList;
    private int itemLayout;

    /**
     * 생성자
     * @param items
     * @param itemLayout
     */
    public DetailCustomAdapter(List<CardForDetailSchedule> items , int itemLayout){
        this.dataList = items;
        this.itemLayout = itemLayout;
    }
    /**
     * 레이아웃을 만들어서 Holer에 저장
     * @param viewGroup
     * @param viewType
     * @return
     */
    @Override
    public DetailCustomAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout,viewGroup,false);
        return new DetailCustomAdapter.ViewHolder(view);
    }

    /**
     * listView getView 를 대체
     * 넘겨 받은 데이터를 화면에 출력하는 역할
     *
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(DetailCustomAdapter.ViewHolder viewHolder, int position) {

        final CardForDetailSchedule item = dataList.get(position);
        viewHolder.destTitleTxt.setText(item.getDestTitle());
        viewHolder.ratingBar.setRating(item.getRating());
        viewHolder.reviewTxt.setText(item.getReview());
        viewHolder.destImg.setImageResource(item.getDestImg());
        viewHolder.destImg.setBackground(viewHolder.destImg.getDrawable());
        viewHolder.destImg.setImageResource(0);
        viewHolder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * 뷰 재활용을 위한 viewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView destTitleTxt;
        private RatingBar ratingBar;
        private TextView reviewTxt;
        private ImageView destImg;

        public ViewHolder(View itemView) {
            super(itemView);

            destTitleTxt = (TextView)itemView.findViewById(R.id.destTitleTxt);
            ratingBar = (RatingBar) itemView.findViewById(R.id.detailRatingBar);
            reviewTxt = (TextView) itemView.findViewById(R.id.reviewTxt);
            destImg = (ImageView) itemView.findViewById(R.id.destImg);
        }
    }
}
