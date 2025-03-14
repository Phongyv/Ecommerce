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

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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

        GridView gridView = findViewById(R.id.gridView);
        // Danh sách các mục
        List<String> items = Arrays.asList("Ithhh 1", "Item 2", "Item 3", "Item 4","hfem5");
        GridAdapter adapter = new GridAdapter(this, items);
        gridView.setAdapter(adapter);
        // Bạn có thể thiết lập Listener nếu cần
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            // Xử lý sự kiện click ở đây
        });

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
                Intent cart = new Intent(MainActivity.this, CartActivity.class);
                startActivity(cart);
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
                Intent settings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settings);
            }
        });

    }

}
