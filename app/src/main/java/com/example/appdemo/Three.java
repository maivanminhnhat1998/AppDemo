package com.example.appdemo;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appdemo.Model.ListviewModel;

import java.util.ArrayList;
import java.util.List;

public class Three extends AppCompatActivity {
    TextView txtUsername, txtPhonenumber;
    ImageView image1 , image2;
    ListView listView;
    // tham chiếu qua Four
     static List<ListviewModel> modelList;
     static CustumAdapter custumAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        onInnit();
        setOnData();

        custumAdapter = new CustumAdapter(Three.this,R.layout.listview_custum_three,modelList);
        listView.setAdapter(custumAdapter);






    }

    private void setOnData() {
        modelList = new ArrayList<>();
        modelList.add(new ListviewModel(1,"Trần Thanh Hoà","01658041503","TP.HCM"));
        modelList.add(new ListviewModel(2,"Trần Văn A","01658041503","TP.HCM"));
        modelList.add(new ListviewModel(3,"Trần Văn B","01658041503","TP.HCM"));
        modelList.add(new ListviewModel(4,"Trần Văn C","01658041503","TP.HCM"));
        modelList.add(new ListviewModel(5,"Trần Văn D","01658041503","TP.HCM"));
        modelList.add(new ListviewModel(6,"Trần Văn F","01658041503","TP.HCM"));
        modelList.add(new ListviewModel(7,"Trần Văn G","01658041503","TP.HCM"));
        modelList.add(new ListviewModel(8,"Trần Văn T","01658041503","TP.HCM"));

    }

    private void onInnit() {
        listView = (ListView) findViewById(R.id.listview);
        txtPhonenumber = (TextView) findViewById(R.id.txtPhonenumber);
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        image1 = (ImageView)findViewById(R.id.image1);
        image2 =(ImageView)findViewById(R.id.image2);
    }

    public class CustumAdapter extends ArrayAdapter<ListviewModel> {
        private Context mContext;
        private int mResource;
        private List<ListviewModel> mList;


        public CustumAdapter( Context context, int resource, List<ListviewModel> objects) {
            super(context, resource, objects);
            this.mContext = context;
            this.mResource = resource;
            this.mList = objects;
        }

        @Override
        public View getView(int position,View convertView, ViewGroup parent) {
            viewHolder viewHolder = null;
            if (viewHolder == null){
                convertView = LayoutInflater.from(mContext).inflate(mResource,parent,false);
                viewHolder = new viewHolder();
                viewHolder.txtUsername = convertView.findViewById(R.id.txtUsername);
                viewHolder.txtPhonenumber = convertView.findViewById(R.id.txtPhonenumber);
                viewHolder.image1 = convertView.findViewById(R.id.image1);
                viewHolder.image2 = convertView.findViewById(R.id.image2);
                convertView.setTag(viewHolder);
            }else {
                //Lấy tất cả dữ liệu
                viewHolder = (viewHolder) convertView.getTag();
            }
            //Lấy vị trí từng dòng
            final ListviewModel listviewModel = mList.get(position);
            viewHolder.txtUsername.setText(String.valueOf(listviewModel.getUsername()));
            viewHolder.txtPhonenumber.setText(String.valueOf(listviewModel.getPhoneNumber())+ " - " + String.valueOf(listviewModel.getAddress()));
            //Avatar call
            viewHolder.image2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel: "+ listviewModel.getPhoneNumber()));
                    if (ContextCompat.checkSelfPermission(Three.this,
                            Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(Three.this,
                                new String[]{Manifest.permission.CALL_PHONE},
                                1);

                        // MY_PERMISSIONS_REQUEST_CALL_PHONE is an
                        // app-defined int constant. The callback method gets the
                        // result of the request.
                    } else {
                        //You already have permission
                        try {
                            startActivity(intent);
                        } catch(SecurityException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            //Avatar detail và Truyền dữ liệu qua Four.java
                viewHolder.image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,Four.class);
                    intent.putExtra("getID",listviewModel);
                    mContext.startActivity(intent);

                }
            });
            return convertView;
        }
        //Ánh xạ
        public class viewHolder{
            TextView txtUsername, txtPhonenumber;
            ImageView image1, image2;

        }
    }

}
