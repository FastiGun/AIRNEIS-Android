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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, RedirectionInterface{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationDrawer;

    Fragment inscriptionFragment;
    Fragment loginFragment;
    Fragment homePageFragment;
    Fragment categoryFragment;
    Fragment listCategoryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        homePageFragment = new HomePageFragment((RedirectionInterface) this);
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

    public void redirectToInscription() {
        inscriptionFragment = new InscriptionFragment((RedirectionInterface) this);
        loadFragment(inscriptionFragment);
    }

    public void redirectToLogin() {
        loginFragment = new LoginFragment( (RedirectionInterface) this);
        loadFragment(loginFragment);
    }

    public void redirectToCategory() {
        Categorie cat = new Categorie(1, "Chaises");
        Produit[] produitList = new Produit[2];
        produitList[0] = new Produit(1, "Chaise Antoine", 12, 4, "Je veux", cat, 4, "nfjgbfjf");
        produitList[1] = new Produit(2, "Chaise Benj", 2, 2, "Sent mauvais et gros", cat , 4, "nfjgbfjf");
        categoryFragment = new CategoryFragment(produitList, (RedirectionInterface) this);
        loadFragment(categoryFragment);
    }
    public void redirectToCategory2() {
        Categorie cat = new Categorie(2, "Tabouret");
        Produit[] produitList = new Produit[2];
        produitList[0] = new Produit(1, "Tabouret Antoine", 12, 4, "Je veux encore", cat, 4, "nfjgbfjf");
        produitList[1] = new Produit(2, "Tabouret Benj", 2, 2, "Sent mauvais et gros, toujours pas", cat , 4, "nfjgbfjf");
        categoryFragment = new CategoryFragment(produitList, (RedirectionInterface) this);
        loadFragment(categoryFragment);
    }

    public void redirectToCategory3() {
        Categorie cat = new Categorie(3, "Table");
        Produit[] produitList = new Produit[2];
        produitList[0] = new Produit(1, "Table Antoine", 12, 4, "ok", cat, 4, "nfjgbfjf");
        produitList[1] = new Produit(2, "Table Benj", 2, 2, "super", cat , 4, "nfjgbfjf");
        categoryFragment = new CategoryFragment(produitList, (RedirectionInterface) this);
        loadFragment(categoryFragment);
    }

    public void redirectToCategoryList(){
        Categorie[] cat = new Categorie[3];
        cat[0] = new Categorie(1,"Chaises");
        cat[1] = new Categorie(2,"Tabourets");
        cat[2] = new Categorie(3,"Tables");
        listCategoryFragment = new ListCategoryFragment(cat, (RedirectionInterface) this);
        loadFragment(listCategoryFragment);
    }
}