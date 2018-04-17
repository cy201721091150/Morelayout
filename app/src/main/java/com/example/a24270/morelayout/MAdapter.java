package com.example.a24270.morelayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by 24270 on 2018/4/16.
 */

public class MAdapter  extends RecyclerView.Adapter<MAdapter.ViewHolder>{
    private List<morelayout> mMorelayoutList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View morelayoutView;
        ImageView morelayoutImage;
        TextView morelayoutName;
        public ViewHolder(View view){
            super(view);
            morelayoutView=view;
            morelayoutImage=(ImageView) view.findViewById(R.id.morelayout_image);
            morelayoutName=(TextView) view.findViewById(R.id.morelayout_name);
        }
    }
    public MAdapter(List<morelayout>fruitList){
        mMorelayoutList=fruitList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.morelayout,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.morelayoutView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position=holder.getAdapterPosition();
                morelayout more=mMorelayoutList.get(position);
                Toast.makeText(v.getContext(),"you clicked view"+more.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.morelayoutImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position= holder.getAdapterPosition();
                morelayout more=mMorelayoutList.get(position);
                Toast.makeText(v.getContext(),"you clicked image"+more.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;

    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position) {
        morelayout more = mMorelayoutList.get(position);
        holder.morelayoutImage.setImageResource(more.getImageId());
        holder.morelayoutName.setText(more.getName());
    }
    @Override
    public int getItemCount(){
        return mMorelayoutList.size();
    }
}

