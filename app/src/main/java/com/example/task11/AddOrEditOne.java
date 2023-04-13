package com.example.task11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddOrEditOne extends AppCompatActivity {

    Button btn_addCroucery;
    Button btn_cancel;

    private EditText InputName;
    private EditText InputMemo;

    private int counter;
    private Context context;

    public AddOrEditOne() {
        this.counter = counter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_edit_one);

        InputName = findViewById(R.id.et_FoodName);
        InputMemo=findViewById(R.id.et_addMemo);

        btn_addCroucery=findViewById(R.id.btn_addCrousery);
        btn_cancel=findViewById(R.id.btn_cancel);
        context=this;



        /**
        public void addFood(View view){
            StringBuilder name = new StringBuilder(InputName.getText().toString());
            StringBuilder memo = new StringBuilder(InpurMemo.getText().toString());
            int time = Storage.getInstance().getSize();

            Storage.getInstance().addUser(new Food(name.toString(),memo.toString(),time));
            Storage.getInstance().saveFoods(this);
            Storage.getInstance().saveFoods(this);
        }

        public void cancel(View view){
            Intent intent = new Intent(AddOrEditOne.this,MainActivity.class);
            startActivity(intent);
        }
        **/
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddOrEditOne.this,MainActivity.class);
                startActivity(intent);

            }
        });
        //Tähän lisäysmetodi

        btn_addCroucery.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                StringBuilder name = new StringBuilder(InputName.getText().toString());
                StringBuilder memo = new StringBuilder(InputMemo.getText().toString());
                int time = Storage.getInstance().getTimeCalculator()+1;
                Storage.getInstance().setTimeCalculator(time);

                Storage.getInstance().addUser(new Food(name.toString(),memo.toString(),time));
                Storage.getInstance().saveFoods(AddOrEditOne.this);

            }



        });


    }
}