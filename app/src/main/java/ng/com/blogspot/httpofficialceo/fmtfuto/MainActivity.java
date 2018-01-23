package ng.com.blogspot.httpofficialceo.fmtfuto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import ng.com.blogspot.httpofficialceo.fmtfuto.adapter.CustomGridAdapter;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toast myToast;

    Intent myIntent;

    GridView gridView;

    String[] iconName = new String[]{" Currency Converter",
            "  Simple  Interest", "Compound   Interest",
            "    ROI Calculator", "    TVM Calculator",
            "Calculator", "Ratios Calculator",
            " IRR NPV Calculator", " Stock Calculator"};

    int[] iconImage = new int[]{
            R.drawable.currenyconverter,
            R.drawable.simpleinterest,
            R.drawable.compoundinterest,
            R.drawable.roiicon, R.drawable.tvmicon,
            R.drawable.calculator, R.drawable.ratios,
            R.drawable.irricon, R.drawable.stockicon};

    private String url = "https://www.google.com/maps/place/" +
            "Federal+University+of+Technology+Owerri+Futo/@5.3866373,6.9894373,799m/" +
            "data=!3m2!1e3!4b1!4m5!3m4!1s0x10425ddd492a75eb:0xdf1788bd477488da!8m2!3d5.386632!4d6.9916314?hl=en";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


            drawer.postDelayed(new Runnable() {
                @Override
                public void run() {
                    drawer.openDrawer(Gravity.LEFT);
                }
            }, 1500);

        CustomGridAdapter adapter = new CustomGridAdapter(this, iconName, iconImage);
        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(myToast != null){
                    myToast.cancel();
                }

                switch (position){

                    case 0:

                       myToast =  Toast.makeText(MainActivity.this, "Currency clicked", Toast.LENGTH_SHORT);
                        myToast.show();
                        break;
                    case 1:
                       myIntent = new Intent(MainActivity.this, SimpleInterestActivity.class);
                        startActivity(myIntent);
                        break;

                    case 2:
                        myIntent = new Intent(MainActivity.this, CompoundInterestActivity.class);
                        startActivity(myIntent);
                        break;
                    case 3:
                        myToast =  Toast.makeText(MainActivity.this, "ROI clicked", Toast.LENGTH_SHORT);
                        myToast.show();
                        break;
                    case 4:
                        myToast =  Toast.makeText(MainActivity.this, "TVM clicked", Toast.LENGTH_SHORT);
                        myToast.show();
                        break;
                    case 5:
                        myToast =  Toast.makeText(MainActivity.this, "calculator clicked", Toast.LENGTH_SHORT);
                        myToast.show();
                        break;
                    case 6:
                        Intent myIntent = new Intent(MainActivity.this, RatiosActivity.class);
                        startActivity(myIntent);
                        break;
                    case 7:
                        myToast =  Toast.makeText(MainActivity.this, "IRR clicked", Toast.LENGTH_SHORT);
                        myToast.show();
                        break;
                    case 8:
                        myToast =  Toast.makeText(MainActivity.this, "stock clicked", Toast.LENGTH_SHORT);
                        myToast.show();
                        break;
                    case 9:


                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout)  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.year_one) {
            // Handle the camera action
        } else if (id == R.id.year_two) {

        } else if (id == R.id.year_three) {

        } else if (id == R.id.year_four) {

        } else if (id == R.id.year_five) {

        } else if (id == R.id.aprreciation_text) {

        }else if (id == R.id.map_icon){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);

        }else if (id == R.id.about_department){

            myIntent = new Intent(MainActivity.this, AboutDepartment.class);
            startActivity(myIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    private void loadFragment (Fragment fragment){
//        FragmentManager fragmentManager = getFragmentManager();
//
//       FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.framelayout, fragment);
//        transaction.commit();
//
//
//    }


}
