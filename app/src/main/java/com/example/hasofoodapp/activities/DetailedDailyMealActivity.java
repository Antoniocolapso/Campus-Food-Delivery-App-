package com.example.hasofoodapp.activities;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hasofoodapp.R;
import com.example.hasofoodapp.adapters.DetailedDailyAdapter;
import com.example.hasofoodapp.models.DetailedDailyModel;

import java.util.ArrayList;
import java.util.List;

public class DetailedDailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailedDailyModel>detailedDailyModelList;
    DetailedDailyAdapter dailyAdapter;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);

        String type = getIntent().getStringExtra("type");

        recyclerView =findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelList = new ArrayList<>();
        dailyAdapter = new DetailedDailyAdapter(detailedDailyModelList);
        recyclerView.setAdapter(dailyAdapter);


        if (type != null && type.equalsIgnoreCase("breakfast")){
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.fav1,"Breakfast","description","120","4.4","10:00 - 19:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.fav2,"Breakfast","description","120","4.4","10:00 - 19:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.fav3,"Breakfast","description","120","4.4","10:00 - 19:00"));
            dailyAdapter.notifyDataSetChanged();
        }

        if (type != null && type.equalsIgnoreCase("sweets")){
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s1,"sweets","description","120","4.4","10:00 - 19:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s2,"sweets","description","120","4.4","10:00 - 19:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s3,"sweets","description","120","4.4","10:00 - 19:00"));
            dailyAdapter.notifyDataSetChanged();
        }
        if (type != null && type.equalsIgnoreCase("dinner")){
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.dinner,"dinner","description","120","4.4","10:00 - 19:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.fries1,"dinner","description","120","4.4","10:00 - 19:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.burger1,"dinner","description","120","4.4","10:00 - 19:00"));
            dailyAdapter.notifyDataSetChanged();
        }        if (type != null && type.equalsIgnoreCase("lunch")){
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.lunch,"lunch","description","120","4.4","10:00 - 19:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.ver2,"lunch","description","120","4.4","10:00 - 19:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s2,"lunch","description","120","4.4","10:00 - 19:00"));
            dailyAdapter.notifyDataSetChanged();
        }        if (type != null && type.equalsIgnoreCase("coffee")){
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.coffe,"coffee","description","120","4.4","10:00 - 19:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.coffe,"coffee","description","120","4.4","10:00 - 19:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.coffe,"coffee","description","120","4.4","10:00 - 19:00"));
            dailyAdapter.notifyDataSetChanged();
        }

    }
}