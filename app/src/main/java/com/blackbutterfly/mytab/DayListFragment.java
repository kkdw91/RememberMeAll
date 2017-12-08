package com.blackbutterfly.mytab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class DayListFragment extends Fragment {


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup dayList = (ViewGroup)   inflater.inflate(R.layout.fragment_day_list, container,false);
        LinearLayout dayListContainer = (LinearLayout) dayList.findViewById(R.id.llDayListContainer);
        for(int i=0;i<3;i++){
            appendItemView(inflater,container,dayListContainer);
        }
        return dayList;
    }

    private void appendItemView(LayoutInflater inflater, ViewGroup container, LinearLayout dayListContainer){
        ViewGroup itemView = (ViewGroup)   inflater.inflate(R.layout.fragment_day_list_item,container,false);
        dayListContainer.addView(itemView);
        final LinearLayout dayListItemContainer = (LinearLayout) itemView.findViewById(R.id.llDAyListItemContainer);
        for(int j=0;j<5;j++){
            appendSpotView(inflater, container, dayListItemContainer);
        }
    }
    private void appendSpotView(LayoutInflater inflater, ViewGroup container, final LinearLayout dayListItemContainer){
        final ViewGroup spotView = (ViewGroup)   inflater.inflate(R.layout.spot_item,container,false);
        Button btnRemove = (Button) spotView.findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dayListItemContainer.removeView(spotView);
            }
        });
        dayListItemContainer.addView(spotView);
    }
}
