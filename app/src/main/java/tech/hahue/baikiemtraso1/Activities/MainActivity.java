package tech.hahue.baikiemtraso1.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import tech.hahue.baikiemtraso1.Adapters.HomeAdapter;
import tech.hahue.baikiemtraso1.Models.Food;
import tech.hahue.baikiemtraso1.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private NavigationView nav_view;
    private DrawerLayout drawer_layout;
    private TextView toolbar_title_home;
    private FloatingActionButton btn_fab_new;
    private ArrayList<Food> arrFoods;
    private RecyclerView rcv_home;
    private HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setToolbar();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar_home);
        drawer_layout = findViewById(R.id.drawer_layout);
        nav_view = findViewById(R.id.nav_view);
        toolbar_title_home = findViewById(R.id.toolbar_title_home);
        btn_fab_new = findViewById(R.id.btn_fab_new);
        nav_view.setNavigationItemSelectedListener(this);
        btn_fab_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getResources().getString(R.string.toast_add_new), Toast.LENGTH_SHORT).show();
            }
        });

        rcv_home = findViewById(R.id.rcv_home);
        arrFoods = new ArrayList<>();
        arrFoods.add(new Food("Cơm rang dưa bò", 20000));
        arrFoods.add(new Food("Cơm rang gà", 25000));
        arrFoods.add(new Food("Cơm rang thập cẩm", 30000));
        arrFoods.add(new Food("Cơm rang thịt băm", 35000));
        arrFoods.add(new Food("Cơm rang cá khô", 40000));

        homeAdapter = new HomeAdapter(MainActivity.this, arrFoods);
        rcv_home.setAdapter(homeAdapter);
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_title_home.setText(getResources().getString(R.string.nav_home));
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_toggle));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer_layout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.nav_menus:
                startActivity(new Intent(this, MenuActivity.class));
                break;
            case R.id.nav_employee:
                startActivity(new Intent(this, EmployeeActivity.class));
                break;
            case R.id.nav_chart:
                startActivity(new Intent(this, ChartActivity.class));
                break;
            case R.id.nav_setting:
                startActivity(new Intent(this, SettingsActivity.class));
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
