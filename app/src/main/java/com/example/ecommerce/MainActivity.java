package com.example.ecommerce;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public boolean loginStatus = true;
    Button btn;
    ImageSlider image_slider;
    ImageView categories,cart,more,setting;
    TextView viewAll;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Ecommerce);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //render image
        ImageView imageView20 = findViewById(R.id.imageView20);
        String url = "https://cdn.tgdd.vn/Products/Images/42/335177/samsung-galaxy-a56-5g-xanh-thumbai-600x600.jpg"; // Thay đổi URL tại đây
        Glide.with(this)
                .load(url)
                .into(imageView20);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //auto slide show
        image_slider = findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.slide8, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide7, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide5, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide6, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide9, ScaleTypes.FIT));
        image_slider.setImageList(slideModels);


        categories = findViewById(R.id.imageView3);
        cart = findViewById(R.id.imageView8);
        more = findViewById(R.id.imageView6);
        setting = findViewById(R.id.imageView7);
        viewAll = findViewById(R.id.textView8);

        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewAll =new Intent(MainActivity.this,CategoriesActivity.class);
                startActivity(viewAll);
            }
        });

        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categories = new Intent(MainActivity.this, CategoriesActivity.class);
                startActivity(categories);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginStatus == true){
                    Intent cart = new Intent(MainActivity.this, CartActivity.class);
                    startActivity(cart);
                } else {
                    Intent loginCart = new Intent(MainActivity.this, LoginScreen.class);
                    startActivity(loginCart);
                }
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent more = new Intent(MainActivity.this, MoreActivity.class);
                startActivity(more);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginStatus == true){
                    Intent settings = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(settings);
                } else{
                    Intent loginSettings = new Intent(MainActivity.this, LoginScreen.class);
                    startActivity(loginSettings);
                }

            }
        });

    }

}
