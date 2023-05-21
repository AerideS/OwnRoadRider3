package com.example.ownroadrider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListDestCustomAdapter extends RecyclerView.Adapter<ListDestCustomAdapter.ViewHolder> {
    private List<CardForDestination> dataList;
    private int itemLayout;

    /**
     * 생성자
     * @param items
     * @param itemLayout
     */
    public ListDestCustomAdapter(List<CardForDestination> items , int itemLayout){
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
    public ListDestCustomAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout,viewGroup,false);
        return new ListDestCustomAdapter.ViewHolder(view);
    }

    /**
     * listView getView 를 대체
     * 넘겨 받은 데이터를 화면에 출력하는 역할
     *
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(ListDestCustomAdapter.ViewHolder viewHolder, int position) {
        final CardForDestination item = dataList.get(position);
        viewHolder.destNameTxt.setText(item.getDestName());
        viewHolder.locationTxt.setText(item.getLocation());
        viewHolder.destImg.setImageResource(item.getDestImg());
        viewHolder.destImg.setBackground(viewHolder.destImg.getDrawable());
        viewHolder.destImg.setImageResource(0);
        if(item.getType() == 0) {
            viewHolder.dipImg.setVisibility(View.GONE);
        }
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
        private TextView destNameTxt;
        private TextView locationTxt;
        private ImageView destImg;
        private CardView dipImg;

        public ViewHolder(View itemView) {
            super(itemView);
            destNameTxt = (TextView)itemView.findViewById(R.id.destNameTxt);
            locationTxt = (TextView) itemView.findViewById(R.id.locationTxt);
            destImg = (ImageView) itemView.findViewById(R.id.destinationImg);
            dipImg = (CardView) itemView.findViewById(R.id.dipImg);
        }
    }
}
