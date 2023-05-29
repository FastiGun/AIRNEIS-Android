package com.example.airneis;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public class HomePageFragment extends Fragment {

    ViewPager carousselViewPager;
    Handler handler;
    Runnable runnable;

    ImageView categoryTop;
    ImageView categoryCenter;
    ImageView categoryBottom;
    int currentImage = 0;
    Button categoryButton;
    RedirectionInterface redirectionListListener;

    String[] imageUrls = new String[]{
        "https://www.for-interieur.fr/wp-content/uploads/2017/12/enfilade-scandinave-2.jpg",
    "https://www.for-interieur.fr/wp-content/uploads/2017/12/enfilade-scandinave-2.jpg",
    "https://www.for-interieur.fr/wp-content/uploads/2017/12/enfilade-scandinave-2.jpg"
    };

    public HomePageFragment(RedirectionInterface listener) {
        this.redirectionListListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_page_fragment, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        carousselViewPager = view.findViewById(R.id.carousselViewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this.getContext(), imageUrls);
        carousselViewPager.setAdapter(adapter);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                changeImage();
            }
        };
        handler.postDelayed(runnable, 3000);

        categoryTop = view.findViewById(R.id.topCategoryImageView);
        categoryTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionListListener.redirectToFragment("category");
            }
        });

        categoryCenter = view.findViewById(R.id.centerCategoryImageView);
        categoryCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionListListener.redirectToFragment("category");
            }
        });

        categoryBottom = view.findViewById(R.id.bottomCategoryImageView);
        categoryBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionListListener.redirectToFragment("category");
            }
        });

        categoryButton = view.findViewById(R.id.categoryButton);
        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionListListener.redirectToFragment("category_list");
            }
        });
    }

    private void changeImage() {
        currentImage++;
        if (currentImage == imageUrls.length) {
            currentImage = 0;
        }
        carousselViewPager.setCurrentItem(currentImage, true);
        handler.postDelayed(runnable, 3000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }




}
