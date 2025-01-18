package com.example.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class ListViewActivity extends AppCompatActivity {

    private String[] name = {"第一款" ,"第二款", "第三款","第四款","第五款"};
    private String[] price = {"100","130","300","650","900"};

    private int[] pic = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ListView mylistview = findViewById(R.id.listview_lv);
        MyAdapter myAdapter = new MyAdapter();
        mylistview.setAdapter(myAdapter);
    }

      class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return name.length;
        }

        @Override
        public Object getItem(int position) {
            return name[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(ListViewActivity.this,R.layout.listitem,null);

            ImageView iv = view.findViewById(R.id.listview_iv);  //注意这个要用inflate出来的view来调用findViewById
            TextView tv_name = view.findViewById(R.id.listitem_name);
            TextView tv_price = view.findViewById(R.id.listitem_price);

            Log.d("yang", "getView: position"+position);
            iv.setImageResource(pic[position]);
            tv_name.setText(name[position]);
            tv_price.setText(price[position]);

            return view;



        }
    }
}