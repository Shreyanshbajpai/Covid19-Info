package com.uibsoft.covid_info;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.uibsoft.covid_info.Fragment.CountryFrag;
import com.uibsoft.covid_info.Fragment.HelplineFrag;
import com.uibsoft.covid_info.Fragment.HomeFrag;
import com.uibsoft.covid_info.Fragment.IndiaFrag;
import com.uibsoft.covid_info.Fragment.ZoneFrag;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    TextView t1,t2,t3;

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    CollapsingToolbarLayout collapsingToolbarLayout;

    DrawerLayout drawerLayout;

    NavigationView navigationView;
    ActionBarDrawerToggle toggleBtn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewIninit();

        toolbarSetup();


        bottomSetup();

        getDataAPI();

    }

    private void getDataAPI() {



    }

    private void bottomSetup() {


        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){

                    case R.id.Home:

                        Toast.makeText(getApplicationContext(),"Home Fragment",Toast.LENGTH_LONG).show();

                        Fragment homeFrag=new HomeFrag();

                        FragmentManager fragmentManager=getSupportFragmentManager();
                        FragmentTransaction fragmentTransactio=fragmentManager.beginTransaction();

                        fragmentTransactio.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

                        fragmentTransactio.replace(R.id.container,homeFrag).commit();


                        break;
                    case R.id.India:


                        Intent intent=new Intent(MainActivity.this,IndiaActivity.class);
                        startActivity(intent);

               /*         Toast.makeText(getApplicationContext(),"India Fragment",Toast.LENGTH_LONG).show();

                        Fragment indiaFrag=new IndiaFrag();

                        FragmentManager fragmentManager1=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction=fragmentManager1.beginTransaction();

                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

                        fragmentTransaction.replace(R.id.container,indiaFrag).commit();*/
                        break;
                    case R.id.allCountry:

                        Toast.makeText(getApplicationContext(),"Allcountry Fragment",Toast.LENGTH_LONG).show();

                        Fragment country=new CountryFrag();

                        FragmentManager fm=getSupportFragmentManager();
                        FragmentTransaction ft=fm.beginTransaction();

                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

                        ft.replace(R.id.container,country).commit();
                        break;
                    case R.id.symptoms:

                        Toast.makeText(getApplicationContext(),"Symptoms Fragment",Toast.LENGTH_LONG).show();



                        Fragment sypt=new IndiaFrag();

                        FragmentManager fam=getSupportFragmentManager();
                        FragmentTransaction fat=fam.beginTransaction();

                        fat.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

                        fat.replace(R.id.container,sypt).commit();
                        break;




                }


                return false;
            }
        });


    }

    private void toolbarSetup() {

        setSupportActionBar(toolbar);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(),"Menu button Clicked",Toast.LENGTH_LONG).show();

                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });


        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                switch (item.getItemId()){


                    case R.id.home:

                        Toast.makeText(getApplicationContext(),"Home Fragment",Toast.LENGTH_LONG).show();

                        Fragment homeFrag=new HomeFrag();

                        FragmentManager fragmentManager=getSupportFragmentManager();
                        FragmentTransaction fragmentTransactio=fragmentManager.beginTransaction();

                        fragmentTransactio.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

                        fragmentTransactio.replace(R.id.container,homeFrag).commit();

                        drawerLayout.closeDrawer(Gravity.LEFT);


                        break;

                    case R.id.zone:

                        Toast.makeText(getApplicationContext(),"Home Fragment",Toast.LENGTH_LONG).show();

                        Fragment zonefrag=new ZoneFrag();

                        FragmentManager zoneFragManager=getSupportFragmentManager();
                        FragmentTransaction zoneTra=zoneFragManager.beginTransaction();

                        zoneTra.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

                        zoneTra.replace(R.id.container,zonefrag).commit();

                        drawerLayout.closeDrawer(Gravity.LEFT);


                        break;
                    case R.id.covidAware:


                        //
                        Toast.makeText(getApplicationContext(),"COVID-19 AWARENESS",Toast.LENGTH_LONG).show();

                        break;

                    case R.id.helpline:
                        Toast.makeText(getApplicationContext(),"Helpline",Toast.LENGTH_LONG).show();


                        Toast.makeText(getApplicationContext(),"Home Fragment",Toast.LENGTH_LONG).show();

                        Fragment helpFrag=new HelplineFrag();

                        FragmentManager helpFragManager=getSupportFragmentManager();
                        FragmentTransaction helpTra=helpFragManager.beginTransaction();

                        helpTra.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

                        helpTra.replace(R.id.container,helpFrag).commit();

                        drawerLayout.closeDrawer(Gravity.LEFT);


                        break;

                    case R.id.about:
                        Toast.makeText(getApplicationContext(),"About",Toast.LENGTH_LONG).show();

                        break;

                }



                return false;
            }
        });





    }

    private void viewIninit() {


        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t1);
        t3=findViewById(R.id.t1);

        toolbar=findViewById(R.id.toolbar);
        bottomNavigationView=findViewById(R.id.bottom_Menu);
        collapsingToolbarLayout=findViewById(R.id.collLayout);


        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navBar);

    }

    @Override
    protected void onStart() {
        super.onStart();


        Fragment homeFrag=new HomeFrag();

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransactio=fragmentManager.beginTransaction();

        fragmentTransactio.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        fragmentTransactio.replace(R.id.container,homeFrag).commit();
    }
}
