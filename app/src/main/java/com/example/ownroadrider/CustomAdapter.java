package com.example.ownroadrider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private List<CardForSchedule> dataList;
    private int itemLayout;

    /**
     * 생성자
     * @param items
     * @param itemLayout
     */
    public CustomAdapter(List<CardForSchedule> items , int itemLayout){
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
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout,viewGroup,false);
        return new ViewHolder(view);
    }

    /**
     * listView getView 를 대체
     * 넘겨 받은 데이터를 화면에 출력하는 역할
     *
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        final CardForSchedule item = dataList.get(position);

        viewHolder.scheduleTitleTxt.setText(item.getScheduleTitle());
        viewHolder.courseTxt.setText(item.getCourse());
        viewHolder.totalReviewTxt.setText(item.getTotalreview());
        //viewHolder.dest1Img.setImageDrawable(item.getDest1Image());
        viewHolder.itemView.setTag(item);

        // 아이템뷰(하나의 카드뷰) 링크 클릭 리스너
        /*viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getSiteLink()));
                view.getContext().startActivity(it);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * 뷰 재활용을 위한 viewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView scheduleTitleTxt;
        public TextView courseTxt;
        public ImageView dest1Img;
        public ImageView dest2Img;
        public ImageView dest3Img;
        public RatingBar ratingBar;
        public TextView totalReviewTxt;
        public CardView cardScheduleView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardScheduleView = (CardView)itemView.findViewById(R.id.cardScheduleView);
            scheduleTitleTxt = (TextView) itemView.findViewById(R.id.scheduleTitleTxt);
            courseTxt = (TextView) itemView.findViewById(R.id.courseTxt);
            dest1Img = (ImageView) itemView.findViewById(R.id.dest1Img);
            dest2Img = (ImageView) itemView.findViewById(R.id.dest2Img);
            dest3Img = (ImageView) itemView.findViewById(R.id.dest3Img);
            totalReviewTxt = (TextView) itemView.findViewById(R.id.totalReviewTxt);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
        }
    }
}