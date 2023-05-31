package com.example.airneis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.airneis.modeles.Categorie;
import com.example.airneis.modeles.Produit;
import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, RedirectionInterface, ListProductListListener, ListCategoryListListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationDrawer;
    Fragment homePageFragment;
    ListProductFragment listProductFragment;
    ListCategoryFragment listCategoryFragment;


    private HashMap<String, Fragment> fragmentsList = new HashMap<>();
    private Categorie[] cat;
    private Produit[] produitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeFragments();
    }

    private void initializeFragments(){
        Fragment login = new LoginFragment( (RedirectionInterface) this);
        fragmentsList.put("login", login);
        Fragment inscription = new InscriptionFragment((RedirectionInterface) this);
        fragmentsList.put("inscription", inscription);
        homePageFragment = new HomePageFragment((RedirectionInterface) this);
        fragmentsList.put("home", homePageFragment);
        loadFragment(homePageFragment);
    }

    private void initializeViews(){
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationDrawer = findViewById(R.id.navigationDrawer);
        navigationDrawer.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_drawer_opened, R.string.nav_drawer_closed);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        Fragment fragment = null;
        if(item.getItemId() == R.id.action_connect){
            this.drawerLayout.closeDrawer(GravityCompat.START);
            fragment = new LoginFragment((RedirectionInterface) this);
            loadFragment(fragment);
            return true;
        } else if(item.getItemId() == R.id.action_signup){
            this.drawerLayout.closeDrawer(GravityCompat.START);
            fragment = new InscriptionFragment((RedirectionInterface) this);
            loadFragment(fragment);
            return true;
        } else if(item.getItemId() == R.id.action_disconnect){
            this.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        } else if(item.getItemId() == R.id.action_cgu){
        this.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
        } else if(item.getItemId() == R.id.action_legalNotices){
        this.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
        } else if(item.getItemId() == R.id.action_contact){
            this.drawerLayout.closeDrawer(GravityCompat.START);
            fragment = new ContactFragment();
            loadFragment(fragment);
            return true;
        } else if(item.getItemId() == R.id.action_socialNetwork){
            this.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
            return true;
        }
        return false;
    }

    public void redirectToFragment(String fragmentName) throws RuntimeException{
        if (fragmentsList.containsKey(fragmentName)){
            loadFragment(fragmentsList.get(fragmentName));
            return;
        }

        if(fragmentsList.containsKey("home")) {
            loadFragment(fragmentsList.get("home"));
            return;
        }

        throw new RuntimeException("No fragment home or " + fragmentName + " in the list.");
    }

    @Override
    public void onCategoryClick(String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://airneis-junia.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Produit[]> callListProduct = webServicesInterface.getListProduct(id);

        callListProduct.enqueue(new Callback<Produit[]>() {
            @Override
            public void onResponse(Call<Produit[]> call, Response<Produit[]> response) {
                listProductFragment = new ListProductFragment(response.body(),(ListProductListListener) MainActivity.this);
                loadFragment(listProductFragment);

            }


            @Override
            public void onFailure(Call<Produit[]> call, Throwable t) {
                Log.e("404", "Error when retrieving products");
                Log.e("404", t.getMessage());
            }
        });
    }
    public void onCategoryClickButton() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://airneis-junia.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Categorie[]> callListCategory = webServicesInterface.getListCategory();

        callListCategory.enqueue(new Callback<Categorie[]>() {
            @Override
            public void onResponse(Call<Categorie[]> call, Response<Categorie[]> response) {
                listCategoryFragment = new ListCategoryFragment(response.body(),(ListCategoryListListener) MainActivity.this);
                loadFragment(listCategoryFragment);
            }

            @Override
            public void onFailure(Call<Categorie[]> call, Throwable t) {
                Log.e("404", "Error when retrieving category list");
                Log.e("404", t.getMessage());
            }
        });
    }
}