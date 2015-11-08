package com.waxyhexagon.studeea;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Home extends AppCompatActivity
        implements  NavigationView.OnNavigationItemSelectedListener, EditProfile.OnFragmentInteractionListener,
                    Settings.OnFragmentInteractionListener, MyProfile.OnFragmentInteractionListener,
                    Matches.OnFragmentInteractionListener{

    Intent intent;

    FragmentManager fragmentManager = getSupportFragmentManager();
    //FragmentTransaction ft = fragmentManager.beginTransaction();

    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //-----------------------------------------------------------------------------------------

        boolean fragmentToStart = getIntent().getBooleanExtra("USERINDATABASE",false);
        //boolean fragmentToStart = true;
        if (fragmentToStart){
            fragmentManager.beginTransaction()
                    .replace(R.id.content, Matches.newInstance())
                    .commit();
        }else{
            fragmentManager.beginTransaction()
                    .replace(R.id.content, EditProfile.newInstance())
                    .commit();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content, Matches.newInstance())
                    .commit();
        } else if (id == R.id.nav_myprofile) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content, MyProfile.newInstance())
                    .commit();
        } else if (id == R.id.nav_editprofile) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content, EditProfile.newInstance())
                    .commit();
        } else if (id == R.id.nav_settings) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content, Settings.newInstance())
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
