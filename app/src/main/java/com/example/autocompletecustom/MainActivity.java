package com.example.autocompletecustom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private List<countryItem> countryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillCountryList();
        AutoCompleteTextView editTex=findViewById(R.id.actv);
        AutoCompleteCountryAdabter adabter=new AutoCompleteCountryAdabter(this,countryList);
        editTex.setAdapter(adabter);

    }
    private void fillCountryList(){
    countryList=new ArrayList<>();
    countryList.add(new countryItem("Afghanistan",R.drawable.afghanistan));
    countryList.add(new countryItem("Albania",R.drawable.albania));
    countryList.add(new countryItem("Algeria",R.drawable.algeria));
    countryList.add(new countryItem("Andorra",R.drawable.andorra));
    countryList.add(new countryItem("Angola",R.drawable.angola));


    }
}
