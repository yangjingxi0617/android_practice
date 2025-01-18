package com.example.test;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.test.databinding.ActivityBottomNatigationBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class BottomNatigation extends AppCompatActivity {

    List<Fragment> list;
    BottomNavigationView bv;

    private ActivityBottomNatigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bottom_natigation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding  = ActivityBottomNatigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bv = binding.bottomnavigationBv;//就可以直接用了
        //bv = findViewById(R.id.bottomnavigation_bv);
        list = new ArrayList<>();
        list.add(new homefragment());
        list.add(new addressbooklfragment());
        list.add(new discoveryfragment());
        list.add(new mefragment());

        showFragment(list.get(0));

        bv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_weixin:
                        showFragment(list.get(0));
                        break;
                    case R.id.menu_tongxunlu:
                        showFragment(list.get(1));
                        break;
                    case R.id.menu_discovery:
                        showFragment(list.get(2));
                        break;
                    case R.id.menu_me:
                        showFragment(list.get(3));
                        break;
                }
                return true;
            }
        });
    }
    private void showFragment(Fragment fragment){
        //
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container,fragment);
        ft.commit();
    }
}