package com.example.a3aug_total_applecount_fragments3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentCommunicationListener {

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.flContainer,new TotalApplesFragment())
                .commit();
    }


    @Override
    public void datafromBuyApplePage(Bundle bundle) {
        if (bundle != null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            TotalApplesFragment totalApplesFragment = new TotalApplesFragment();
            totalApplesFragment.setArguments(bundle);
            transaction.replace(R.id.flContainer,totalApplesFragment).commit();

        }
    }

    @Override
    public void datafromAvailableApplePage(Bundle bundle) {

        if (bundle != null){

            FragmentTransaction transaction = fragmentManager.beginTransaction();
            BuyApplesFragment applesFragment = new BuyApplesFragment();
            applesFragment.setArguments(bundle);
            transaction.replace(R.id.flContainer,applesFragment).addToBackStack("").commit();

        }

    }
}