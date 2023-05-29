package com.example.airneis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.airneis.modeles.Categorie;
import com.example.airneis.modeles.Produit;
import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, RedirectionInterface{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationDrawer;
    Fragment homePageFragment;


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
        createData();
        Fragment login = new LoginFragment( (RedirectionInterface) this);
        fragmentsList.put("login", login);
        Fragment inscription = new InscriptionFragment((RedirectionInterface) this);
        fragmentsList.put("inscription", inscription);
        Fragment category = new CategoryFragment(produitList, (RedirectionInterface) this);
        fragmentsList.put("category", category);
        Fragment category_list = new ListCategoryFragment(cat, (RedirectionInterface) this);
        fragmentsList.put("category_list", category_list);
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

    public void createData(){
        cat = new Categorie[3];
        cat[0] = new Categorie(1,"Chaises");
        cat[1] = new Categorie(2,"Tabourets");
        cat[2] = new Categorie(3,"Tables");
        produitList = new Produit[6];
        produitList[0] = new Produit(1, "Chaise Ant", 12, 4, "ok", cat[0], 4, "ex");
        produitList[1] = new Produit(2, "Chaise Benj", 2, 2, "ok", cat[0] , 4, "ex");
        produitList[2] = new Produit(1, "Tabouret Ant", 12, 4, "ok", cat[1], 4, "ex");
        produitList[3] = new Produit(2, "Tabouret Benj", 2, 2, "ok", cat[1] , 4, "ex");
        produitList[4] = new Produit(1, "Table Ant", 12, 4, "ok", cat[2], 4, "ex");
        produitList[5] = new Produit(2, "Table Benj", 2, 2, "super", cat[2] , 4, "ex");
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
}