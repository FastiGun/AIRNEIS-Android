package com.example.airneis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.airneis.modeles.Adresse;
import com.example.airneis.modeles.Categorie;
import com.example.airneis.modeles.Client;
import com.example.airneis.modeles.Produit;
import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, RedirectionInterface, ListProductListListener, ListCategoryListListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationDrawer;
    Fragment homePageFragment;
    Fragment accountFragment;
    Fragment addressFragment;
    ListProductFragment listProductFragment;
    ListCategoryFragment listCategoryFragment;

    ProductFragment productFragment;
    LoginFragment loginFragment;
    AuthentificationClass authentification;
    Menu nav_menu;

    private HashMap<String, Fragment> fragmentsList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getApplicationContext();
        authentification = new AuthentificationClass(context);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeFragments();
    }

    private void initializeFragments() {
        Fragment login = new LoginFragment((RedirectionInterface) this);
        fragmentsList.put("login", login);
        Fragment inscription = new InscriptionFragment((RedirectionInterface) this);
        fragmentsList.put("inscription", inscription);
        homePageFragment = new HomePageFragment((RedirectionInterface) this);
        fragmentsList.put("home", homePageFragment);
        accountFragment = new AccountFragment((RedirectionInterface) this);
        fragmentsList.put("account", accountFragment);
        addressFragment = new AddressFragment((RedirectionInterface) this);
        fragmentsList.put("address", addressFragment);
        loadFragment(homePageFragment);
    }

    private void initializeViews() {
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationDrawer = findViewById(R.id.navigationDrawer);
        nav_menu = navigationDrawer.getMenu();
        nav_menu.findItem(R.id.action_disconnect).setVisible(false);
        nav_menu.findItem(R.id.action_account).setVisible(false);
        navigationDrawer.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_drawer_opened, R.string.nav_drawer_closed);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        if (item.getItemId() == R.id.action_connect) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
            fragment = new LoginFragment((RedirectionInterface) this);
            loadFragment(fragment);
            return true;
        } else if (item.getItemId() == R.id.action_signup) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
            fragment = new InscriptionFragment((RedirectionInterface) this);
            loadFragment(fragment);
            return true;
        } else if (item.getItemId() == R.id.action_disconnect) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
            authentification.clearAuthToken();
            authentification.clearAuthId();
            redirectToFragment("home");
            return true;
        } else if (item.getItemId() == R.id.action_account) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
            fragment = new AccountPageFragment((RedirectionInterface) this);
            loadFragment(fragment);
            return true;
        } else if (item.getItemId() == R.id.action_cgu) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        } else if (item.getItemId() == R.id.action_legalNotices) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        } else if (item.getItemId() == R.id.action_contact) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
            fragment = new ContactFragment();
            loadFragment(fragment);
            return true;
        } else if (item.getItemId() == R.id.action_socialNetwork) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
            return true;
        }
        return false;
    }

    public void redirectToFragment(String fragmentName) throws RuntimeException {
        if (fragmentsList.containsKey(fragmentName)) {
            loadFragment(fragmentsList.get(fragmentName));
            return;
        }

        if (fragmentsList.containsKey("home")) {
            loadFragment(fragmentsList.get("home"));
            return;
        }

        throw new RuntimeException("No fragment home or " + fragmentName + " in the list.");
    }

    @Override
    public void onCategoryClick(String categorie) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://airneis-junia.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Produit[]> callListProduct = webServicesInterface.getListProduct(categorie);

        callListProduct.enqueue(new Callback<Produit[]>() {
            @Override
            public void onResponse(Call<Produit[]> call, Response<Produit[]> response) {
                listProductFragment = new ListProductFragment(response.body(), (ListProductListListener) MainActivity.this);
                loadFragment(listProductFragment);
            }

            @Override
            public void onFailure(Call<Produit[]> call, Throwable t) {
                Log.e("404", "Error when retrieving product list");
                Log.e("404", t.getMessage());
            }
        });
    }

    @Override
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
                listCategoryFragment = new ListCategoryFragment(response.body(), (ListCategoryListListener) MainActivity.this);
                loadFragment(listCategoryFragment);
            }

            @Override
            public void onFailure(Call<Categorie[]> call, Throwable t) {
                Log.e("404", "Error when retrieving category list");
                Log.e("404", t.getMessage());
            }
        });
    }

    @Override
    public void onProductClick(String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://airneis-junia.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Produit> callProduct = webServicesInterface.getProduct(id);

        callProduct.enqueue(new Callback<Produit>() {
            @Override
            public void onResponse(Call<Produit> call, Response<Produit> response) {
                productFragment = new ProductFragment(response.body());
                loadFragment(productFragment);
            }

            @Override
            public void onFailure(Call<Produit> call, Throwable t) {
                Log.e("404", "Error when retrieving product");
                Log.e("404", t.getMessage());
            }
        });
    }

    @Override
    public void connexion(String mail, String mdp) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://airneis-junia.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Client> callConnexion = webServicesInterface.postConnexion(mail, mdp);

        callConnexion.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                if (response.body() == null) {
                    redirectToFragment("login");
                } else {
                    authentification.saveAuthToken(response.body().getToken());
                    authentification.saveAuthId(response.body().getId());
                    nav_menu.findItem(R.id.action_disconnect).setVisible(true);
                    nav_menu.findItem(R.id.action_account).setVisible(true);
                    nav_menu.findItem(R.id.action_signup).setVisible(false);
                    nav_menu.findItem(R.id.action_connect).setVisible(false);
                    redirectToFragment("home");
                }
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Log.e("404", "Error when login");
                Log.e("404", t.getMessage());
            }
        });
    }

    @Override
    public void registration(String lastName, String name, String mail, String motDePasse) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://airneis-junia.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Client> callInscription = webServicesInterface.postInscription(lastName, name, mail, motDePasse);

        callInscription.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                if (response.body() == null) {
                    redirectToFragment("inscription");
                } else {
                    redirectToFragment("login");
                }
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Log.e("404", "Error when registration");
                Log.e("404", t.getMessage());
            }
        });
    }

    @Override
    public void saveAccount(String token, String _id, String name, String lastName, String numberPhone) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://airneis-junia.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Client> callAccount = webServicesInterface.postClient(token, _id, name, lastName, numberPhone);

        callAccount.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                redirectToFragment("home");
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Log.e("404", "Error when registration");
                Log.e("404", t.getMessage());
            }
        });
    }

    @Override
    public void saveAddress(String token, String _id, String nameAddress, String street, String city, String zipCode, String country, String region, String complement) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://airneis-junia.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Adresse> callAccount = webServicesInterface.postAddressClient(token, _id, nameAddress, street, city, zipCode, country, region, complement);

        callAccount.enqueue(new Callback<Adresse>() {
            @Override
            public void onResponse(Call<Adresse> call, Response<Adresse> response) {
                redirectToFragment("home");
            }

            @Override
            public void onFailure(Call<Adresse> call, Throwable t) {
                Log.e("404", "Error when registration");
                Log.e("404", t.getMessage());
            }
        });
    }
}