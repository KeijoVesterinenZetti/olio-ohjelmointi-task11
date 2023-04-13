package com.example.task11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    Button btn_addFood;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Menu menu;
    private ArrayList<Food> testi = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Storage st = Storage.getInstance();
        st.loadFoods(this);
        Toast.makeText(this,"Listassa on: "+ st.getSize()+" kpl tuoteitta.", Toast.LENGTH_SHORT).show();
        recyclerView = findViewById(R.id.lv_foodList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new RecyvlerViewAdapter(getApplicationContext(),st.getFoodList()));
        btn_addFood=findViewById(R.id.btn_addFood);

        //st.loadFoods(this);




        btn_addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddOrEditOne.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sortmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_aTz:
                Collections.sort(Storage.getInstance().getFoodList(), Food.nameComparator);
                Toast.makeText(this,"Aakkosjärjestys", Toast.LENGTH_SHORT).show();
                recyclerView.setAdapter(new RecyvlerViewAdapter(getApplicationContext(),Storage.getInstance().getFoodList()));
                //mAdapter.notifyDataSetChanged();
                return true;
            case R.id.menu_aikajarjestys:
                Collections.sort(Storage.getInstance().getFoodList(), Food.timeComparator);
                Toast.makeText(this,"Aikajärjestys", Toast.LENGTH_SHORT).show();
                recyclerView.setAdapter(new RecyvlerViewAdapter(getApplicationContext(),Storage.getInstance().getFoodList()));
                //mAdapter.notifyDataSetChanged();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}