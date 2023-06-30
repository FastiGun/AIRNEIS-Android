package com.example.airneis.features.products;

import android.os.Bundle;
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

import com.example.airneis.MainActivity;
import com.example.airneis.R;
import com.example.airneis.RedirectionInterface;
import com.example.airneis.WebServicesInterface;
import com.example.airneis.features.categories.ListCategoryFragment;
import com.example.airneis.features.categories.ListCategoryListListener;
import com.example.airneis.modeles.Categorie;
import com.example.airneis.modeles.Produit;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductFragment extends Fragment {

    TextView productName;
    TextView productPrice;
    TextView productStock;
    TextView productDescription;
    ImageView imageView_productPage;
    Button addToCart;
    ImageView imageView_productSimilar1;
    TextView textView_product1;
    String idProduct;
    String idCategory;

    private final Produit dataSource;

    RedirectionInterface redirectionInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product, null);
    }

    public ProductFragment(Produit dataSource, RedirectionInterface redirectionInterface){
        this.dataSource = dataSource;
        this.redirectionInterface = redirectionInterface;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productName = view.findViewById(R.id.textView_productName);
        productPrice = view.findViewById(R.id.textView_productPrice);
        productStock = view.findViewById(R.id.textView_productStock);
        productDescription = view.findViewById(R.id.textView_productDescription);
        imageView_productPage = view.findViewById(R.id.imageView_productPage);
        imageView_productSimilar1 = view.findViewById(R.id.imageView_productSimilar1);
        textView_product1 = view.findViewById(R.id.textView_product1);
        addToCart = view.findViewById(R.id.button_addToCart);
        productName.setText(dataSource.getNom());
        productPrice.setText(Float.toString(dataSource.getPrix()));
        productStock.setText(Integer.toString(dataSource.getStock()));
        productDescription.setText(dataSource.getDescription());
        String url = dataSource.getImage1();
        Picasso.get().load(url).into(imageView_productPage);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectionInterface.addProductToCart(dataSource.getId());
            }
        });

        idProduct = dataSource.getId();
        idCategory = dataSource.getCategorie();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://airneis-junia.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Produit[]> callListProduct = webServicesInterface.getListProduct(idCategory);

        callListProduct.enqueue(new Callback<Produit[]>() {
            @Override
            public void onResponse(Call<Produit[]> call, Response<Produit[]> response) {
                Produit[] produits = response.body();
                Produit productSimilar = null;

                for (int i = 0; i < produits.length; i++) {
                    if (idProduct != produits[i].getId()) {
                        productSimilar = produits[i];
                        break;
                    }
                }
                textView_product1.setText(productSimilar.getNom());
                String url2 = productSimilar.getImage1();
                Picasso.get().load(url2).into(imageView_productSimilar1);

            }

            @Override
            public void onFailure(Call<Produit[]> call, Throwable t) {
                Log.e("404", "Error when retrieving category list");
                Log.e("404", t.getMessage());
            }
        });

    }
}
