package com.example.grocery_delivery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[]={"Shree Maruti Department","Rohan Super Shopee","New Rangoli Supermarket","Hanuman Supermarket","Balaji Mart","Greensville Super Shopee","Daily Basket Plus","Hari Om Trading","Puneri Fresh Mart","Pravin SuperMarket"};
    String mDesc[]={"Kharadi","Thane","Nanded","Aundh","Amanora","Koragoan Park","Mulund","Kharghar","Kalyan","Bandra","Hinjewadi"};
    int image[] = {R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image11,R.drawable.image8,R.drawable.image4,R.drawable.image6,R.drawable.image3,R.drawable.image9,R.drawable.image8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list_grocery);
        MyAdapter myAdapter=new MyAdapter(this,mTitle,mDesc,image);

        listView.setAdapter(myAdapter);

    }

    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String rTitle[];
        String rDescription[];
        int rImg[];

        MyAdapter(Context c,String title[],String description[], int img[]){
            super(c,R.layout.row_item,R.id.txt1,title);
            this.context=c;
            this.rTitle=title;
            this.rDescription= description;
            this.rImg=img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row= layoutInflater.inflate(R.layout.row_item,parent,false);
            ImageView images=row.findViewById(R.id.image);
            TextView myTitle=row.findViewById(R.id.txt1);
            TextView myDescription= row.findViewById(R.id.txt2);

            images.setImageResource(rImg[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
    }
}


