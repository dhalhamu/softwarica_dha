package com.example.softwarica_dha;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.softwarica_dha.AboutUs.AboutFrag;
import com.example.softwarica_dha.AddStudent.AddStudentFrag;
import com.example.softwarica_dha.Home.HomeFrag;
import com.example.softwarica_dha.Model.Student;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public static List<Student> studentsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListner);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFrag()).commit();


        studentsList = new ArrayList<>();
        studentsList.add(new Student("Dha Lhamu Lama","Pokhara","Female",22,R.drawable.girl));
        studentsList.add(new Student("Marco Sherpa","Jhapa","Male",26,R.drawable.boy));


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectFragment = null;
                    switch (item.getItemId()){

                        case R.id.nav_home:
                            selectFragment = new HomeFrag();
                            break;
                        case R.id.nav_add:
                            selectFragment = new AddStudentFrag();
                            break;
                        case R.id.nav_about:
                            selectFragment = new AboutFrag();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectFragment).commit();
                    return true;
                }
            };
}
