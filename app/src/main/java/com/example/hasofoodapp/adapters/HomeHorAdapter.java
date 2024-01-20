package com.example.hasofoodapp.adapters;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hasofoodapp.R;
import com.example.hasofoodapp.models.HomeHorModel;
import com.example.hasofoodapp.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;

    boolean check =true;
    boolean select= true;
    int row_index=-1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        if (check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add((new HomeVerModel(R.drawable.pizza1, "Pizza", "10:00 - 23:00", "4.9", "Min Rs.45")));
            homeVerModels.add((new HomeVerModel(R.drawable.burger1, "Burger", "10:00 - 23:00", "4.9", "Min Rs.45")));
            homeVerModels.add((new HomeVerModel(R.drawable.fries1, "Fries", "10:00 - 23:00", "4.9", "Min Rs.45")));
            homeVerModels.add((new HomeVerModel(R.drawable.icecream1, "IceCream", "10:00 - 23:00", "4.9", "Min Rs.45")));
            homeVerModels.add((new HomeVerModel(R.drawable.sandwich1, "Sandwich", "10:00 - 23:00", "4.9", "Min Rs.45")));

            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener(){
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onClick(View v){
                    row_index = position;
                    notifyDataSetChanged();

                    if (position == 0){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add((new HomeVerModel(R.drawable.pizza1,"H.Pizza","10:00 - 23:00","4.9","Min Rs.45")));
                        homeVerModels.add((new HomeVerModel(R.drawable.pizza2,"A.Pizza","10:00 - 23:00","4.9","Min Rs.45")));
                        homeVerModels.add((new HomeVerModel(R.drawable.pizza3,"S.Pizza","10:00 - 23:00","4.9","Min Rs.45")));
                        homeVerModels.add((new HomeVerModel(R.drawable.pizza4,"O.Pizza","10:00 - 23:00","4.9","Min Rs.45")));
                        updateVerticalRec.callBack(position,homeVerModels);
                    } else if (position == 1) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add((new HomeVerModel(R.drawable.burger1,"H.Burger","10:00 - 23:00","4.9","Min Rs.45")));
                        homeVerModels.add((new HomeVerModel(R.drawable.burger2,"A.Burger","10:00 - 23:00","4.9","Min Rs.45")));
                        homeVerModels.add((new HomeVerModel(R.drawable.burger4,"S.Burger","10:00 - 23:00","4.9","Min Rs.45")));
                        updateVerticalRec.callBack(position,homeVerModels);
                    } else if (position == 2) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add((new HomeVerModel(R.drawable.fries1,"H.Fries","10:00 - 23:00","4.9","Min Rs.45")));
                        homeVerModels.add((new HomeVerModel(R.drawable.fries2,"A.Fries","10:00 - 23:00","4.9","Min Rs.45")));
                        homeVerModels.add((new HomeVerModel(R.drawable.fries3,"S.Fries","10:00 - 23:00","4.9","Min Rs.45")));
                        homeVerModels.add((new HomeVerModel(R.drawable.fries4,"O.Fries","10:00 - 23:00","4.9","Min Rs.45")));
                        updateVerticalRec.callBack(position,homeVerModels);
                    } else if (position == 3) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add((new HomeVerModel(R.drawable.icecream1,"H.IceCream","10:00 - 23:00","4.9","Min Rs.45")));
                        homeVerModels.add((new HomeVerModel(R.drawable.icecream2,"A.IceCream","10:00 - 23:00","4.9","Min Rs.45")));
                        homeVerModels.add((new HomeVerModel(R.drawable.icecream3,"S.IceCream","10:00 - 23:00","4.9","Min Rs.45")));
                        homeVerModels.add((new HomeVerModel(R.drawable.icecream4,"O.IceCream","10:00 - 23:00","4.9","Min Rs.45")));
                        updateVerticalRec.callBack(position,homeVerModels);
                    } else if (position == 4) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add((new HomeVerModel(R.drawable.sandwich1,"H.Sandwich","10:00 - 23:00","4.9","Min Rs.45")));
                        homeVerModels.add((new HomeVerModel(R.drawable.sandwich2,"A.Sandwich","10:00 - 23:00","4.9","Min Rs.45")));
                        homeVerModels.add((new HomeVerModel(R.drawable.sandwich3,"S.Sandwich","10:00 - 23:00","4.9","Min Rs.45")));
                        homeVerModels.add((new HomeVerModel(R.drawable.sandwich4,"O.Sandwich","10:00 - 23:00","4.9","Min Rs.45")));
                        updateVerticalRec.callBack(position,homeVerModels);
                    }

                }
            });
            if (select){
                if (position ==0 ){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }
            }
            else {
                if (row_index==position){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }
                else {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }
        }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        CardView cardView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_txt);
            cardView = itemView.findViewById(R.id.cardView);
        }

    }
}
