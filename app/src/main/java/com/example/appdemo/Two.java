package com.example.appdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class Two extends AppCompatActivity {
    ViewFlipper viewflipper;
    Button btnNext,btnBack;
    int[] List = {R.drawable.android1, R.drawable.androi2, R.drawable.androi3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        viewflipper = (ViewFlipper)findViewById(R.id.viewflipper);
        viewflipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewflipper.showNext();
            }
        });
            btnNext();
//        btnBack();



        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        for (int i=0; i<List.length; i++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(List[i]);
            viewflipper.addView(imageView);
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        }
        viewflipper.setFlipInterval(5000);
        viewflipper.setAutoStart(true);
    }

//    private void btnBack() {
//        btnBack = (Button) findViewById(R.id.btnBack);
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewflipper.showPrevious();
//            }
//        });
//    }
//
    private void btnNext() {
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Two.this,Three.class);
                startActivity(intent);
            }
        });
    }
}
