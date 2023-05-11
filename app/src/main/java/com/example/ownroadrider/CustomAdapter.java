package com.example.ownroadrider;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private List<CardForSchedule> dataList;
    //private Context mContext;
    private int itemLayout;

    /**
     * 생성자
     * @param items
     * @param itemLayout
     */
    public CustomAdapter(List<CardForSchedule> items , int itemLayout){
        this.dataList = items;
        this.itemLayout = itemLayout;
        //this.mContext = context;
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
        viewHolder.dest1Img.setImageResource(item.getDest1Img());
        viewHolder.dest1Img.setBackground(viewHolder.dest1Img.getDrawable());
        viewHolder.dest1Img.setImageResource(0);
        viewHolder.dest2Img.setImageResource(item.getDest2Img());
        viewHolder.dest2Img.setBackground(viewHolder.dest2Img.getDrawable());
        viewHolder.dest2Img.setImageResource(0);
        viewHolder.dest3Img.setImageResource(item.getDest3Img());
        viewHolder.dest3Img.setBackground(viewHolder.dest3Img.getDrawable());
        viewHolder.dest3Img.setImageResource(0);
        viewHolder.ratingBar.setRating(item.getRating());

        viewHolder.itemView.setTag(item);

        // 아이템뷰(하나의 카드뷰) 링크 클릭 리스너
        /*viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getSiteLink()));
                view.getContext().startActivity(it);
            }
        });*/

        // 아이템 클릭 이벤트 처리.
        viewHolder.cardScheduleView.setClickable(true);
        viewHolder.cardScheduleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mPosition = viewHolder.getAdapterPosition();
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailScheduleActivity.class);

                switch(dataList.get(mPosition).getScheduleTitle()) {
                    case "강. 바다. 호수":
                        intent.putExtra("추천경로파일", "jsons/detaile_1_schedule.json");
                        intent.putExtra("추천경로제목", item.getScheduleTitle());
                        intent.putExtra("추천경로", item.getCourse());
                        intent.putExtra("총평점", item.getRating());
                        intent.putExtra("총평가", item.getTotalreview());
                        break;
                    case "충렬 애국의 혼을 새기는 역사 관광":
                        intent.putExtra("추천경로파일", "jsons/detail_2_schedule.json");
                        intent.putExtra("추천경로제목", item.getScheduleTitle());
                        intent.putExtra("추천경로", item.getCourse());
                        intent.putExtra("총평점", item.getRating());
                        intent.putExtra("총평가", item.getTotalreview());
                        break;
                }

                //context.startActivity(intent);
                //v.getContext().startActivity(intent);
                ((RecommendedScheduleActivity)context).startActivity(intent);
            }
        });

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