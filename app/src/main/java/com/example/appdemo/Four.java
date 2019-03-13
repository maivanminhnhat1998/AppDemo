package com.example.appdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appdemo.Model.ListviewModel;

public class Four extends AppCompatActivity {
    TextView tvName,tvPhone,tvAddress;
    Button btnSave,btnCancel, btnUpdate;
    String mName = "";
    String mPhone = "";
    String mAddress = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        onInit();
        onGetInten();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValiDateForm()){
                    int id = Three.modelList.get(Three.modelList.size() - 1).getId() + 1;
                    ListviewModel model = new ListviewModel(id,mName,mPhone,mAddress);
                    Three.custumAdapter.add(model);
                    Three.custumAdapter.notifyDataSetChanged();
                    Toast.makeText(Four.this,"Add  item success",Toast.LENGTH_LONG).show();
                    onClearForm();

                }

            }
        });

    }

    private boolean ValiDateForm(){
        mName = tvName.getText().toString();
        mPhone = tvPhone.getText().toString();
        mAddress = tvAddress.getText().toString();
        if (mName.length() < 1){
            tvName.setError("Name cannot be null ! ");
            return false;
        }
        if (mPhone.length() < 1){
            tvPhone.setError("Phone cannot be null ! ");
            return false;
        }
        if (mAddress.length() < 1){
            tvAddress.setError("Address cannot be null ! ");
            return false;
        }
        return true;
    }

    private void onClearForm(){
        tvName.clearComposingText();
        tvAddress.clearComposingText();
        tvPhone.clearComposingText();
    }

    private void onGetInten() {
        Intent intent = getIntent();
        ListviewModel listviewModel = (ListviewModel)intent.getSerializableExtra("getID");
        tvName.setText(listviewModel.getUsername());
        tvPhone.setText(listviewModel.getPhoneNumber());
        tvAddress.setText(listviewModel.getAddress());
    }

    private void onInit() {
        btnUpdate =(Button)findViewById(R.id.btnUpdate);
        tvName =(TextView)findViewById(R.id.tvName);
        tvPhone =(TextView)findViewById(R.id.tvPhone);
        tvAddress =(TextView)findViewById(R.id.tvAddress);
        btnSave = (Button)findViewById(R.id.btnSave);
        btnCancel = (Button) findViewById(R.id.btnCancel);

    }


}
