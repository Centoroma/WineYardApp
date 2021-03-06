package com.example.cento.wineyardapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bof.navigationdrawerwineyard.R;
import com.example.cento.wineyardapp.DB.Object.Job;

import java.util.List;

/**
 * Created by Cento on 24.04.2017.
 */

public class WorkAdapter extends ArrayAdapter<Job>{
        public WorkAdapter(Context context, List<Job> jobs) {
            super(context, 0, jobs);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//
            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.double_list,parent, false);
            }

            WorkViewHolder viewHolder = (WorkViewHolder) convertView.getTag();
            if(viewHolder == null){
                viewHolder = new WorkViewHolder();
                viewHolder.action = (TextView) convertView.findViewById(R.id.action);
                viewHolder.employe = (TextView) convertView.findViewById(R.id.employe);
                //viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
                convertView.setTag(viewHolder);
            }

            Job job = getItem(position);

            viewHolder.action.setText(job.getDescription());
            viewHolder.employe.setText(job.getWorker().getLastName()+" "+job.getWorker().getFirstName());
            /*String pathImg = vin.getImg();
            if(pathImg== null || pathImg==""){
                viewHolder.avatar.setImageResource(R.drawable.wine_default);
            }else{
                Bitmap bMap = BitmapFactory.decodeFile(vin.getImg());
                viewHolder.avatar.setImageBitmap(bMap);
            }*/


            return convertView;
        }


        private class WorkViewHolder{
            public TextView action;
            public TextView employe;
            //public ImageView avatar;
        }
}
