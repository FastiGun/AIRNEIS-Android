package com.example.airneis;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.airneis.features.categories.ListCategoryListListener;
import com.example.airneis.modeles.Categorie;
import com.example.airneis.modeles.Client;
import com.example.airneis.modeles.Favoris;
import com.example.airneis.modeles.Produit;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomePageFragment extends Fragment {
    ViewPager carousselViewPager;
    Handler handler;
    Runnable runnable;


    ArrayList<TextView> categoriesText;
    ArrayList<TextView> productText;
    ArrayList<ImageView> categoriesImage;
    ArrayList<ImageView> productImage;
    Retrofit retrofit;
    WebServicesInterface webServicesInterface;





    int currentImage = 0;
    Button categoryButton;
    RedirectionInterface redirectionListListener;

    String[] imageUrls = new String[]{
        "https://www.for-interieur.fr/wp-content/uploads/2017/12/enfilade-scandinave-2.jpg",
    "https://www.for-interieur.fr/wp-content/uploads/2017/12/enfilade-scandinave.jpg",
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

        categoriesImage = new ArrayList<>();
        categoriesImage.add(view.findViewById(R.id.topCategoryImageView));
        categoriesImage.add(view.findViewById(R.id.centerCategoryImageView));
        categoriesImage.add(view.findViewById(R.id.bottomCategoryImageView));

        productImage = new ArrayList<>();
        productImage.add(view.findViewById(R.id.topProductImageView));
        productImage.add(view.findViewById(R.id.centerProductImageView));
        productImage.add(view.findViewById(R.id.bottomProductImageView));

        categoriesText = new ArrayList<>();
        categoriesText.add(view.findViewById(R.id.topCategoryNameTextView));
        categoriesText.add(view.findViewById(R.id.centerCategoryNameTextView));
        categoriesText.add(view.findViewById(R.id.bottomCategoryNameTextView));

        productText = new ArrayList<>();
        productText.add(view.findViewById(R.id.topProductNameTextView));
        productText.add(view.findViewById(R.id.centerProductNameTextView));
        productText.add(view.findViewById(R.id.bottomProductNameTextView));

        retrofit = new Retrofit.Builder()

                .baseUrl("https://airneis-junia.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        webServicesInterface = retrofit.create(WebServicesInterface.class);
        getFavoris();

        categoryButton = view.findViewById(R.id.categoryButton);
        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionListListener.onCategoryClickButton();
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


    public void getFavoris(){
        Call<Favoris> callFavoris = webServicesInterface.getTop();

        callFavoris.enqueue(new Callback<Favoris>() {
            @Override
            public void onResponse(Call<Favoris> call, Response<Favoris> response) {
                String[] categories = response.body().getCategories();
                String[] product = response.body().getProducts();
                for (int i = 0; i < categories.length; i++) {
                    getCategoryFavoris(categories[i], categoriesText.get(i), categoriesImage.get(i) );
                    getProductFavoris(product[i], productText.get(i), productImage.get(i));
                }
            }

            @Override
            public void onFailure(Call<Favoris> call, Throwable t) {
                Log.e("404", "Error when get top information");
                Log.e("404", t.getMessage());
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    public void getCategoryFavoris(String categoryId, TextView categoryText, ImageView categoryImage){
        Call<Categorie> callCategory = webServicesInterface.getCategory(categoryId);

        callCategory.enqueue(new Callback<Categorie>() {
            @Override
            public void onResponse(Call<Categorie> call, Response<Categorie> response) {
                categoryText.setText(response.body().getNom());
                String url = response.body().getImage();
                Picasso.get().load(url).into(categoryImage);
                categoryImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        redirectionListListener.onCategoryClick(categoryId);
                    }
                });
            }

            @Override
            public void onFailure(Call<Categorie> call, Throwable t) {
                categoryText.setText("Fatal Error");
                Log.e("404", "Error when get top information");
                Log.e("404", t.getMessage());
            }
        });
    }

    public void getProductFavoris(String productId, TextView productText, ImageView productImage){
        Call<Produit> callProduit = webServicesInterface.getProduct(productId);

        callProduit.enqueue(new Callback<Produit>() {
            @Override
            public void onResponse(Call<Produit> call, Response<Produit> response) {
                productText.setText(response.body().getNom());
                String url = response.body().getImage1();
                Picasso.get().load(url).into(productImage);
                productImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        redirectionListListener.onProductClick(productId);
                    }
                });
            }

            @Override
            public void onFailure(Call<Produit> call, Throwable t) {
                productText.setText("Fatal Error");
                Log.e("404", "Error when get top information");
                Log.e("404", t.getMessage());
            }
        });
    }
}
