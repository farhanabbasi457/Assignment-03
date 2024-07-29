package com.example.customadaptroptionmenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String data[]={"Facebook","WhatsApp","Youtube","Instagram","Tiktok","Snapchat","Linkledin","Skype"};
        Integer imgid[]={R.drawable.fb,R.drawable.wathsapp,R.drawable.youtube,R.drawable.insta,R.drawable.tiktok,R.drawable.snapchat,R.drawable.linkledon,R.drawable.skype};

        ListView lv=findViewById(R.id.lv);
        CustomList customAdapter = new CustomList(this, data, imgid);
        lv.setAdapter(customAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),data[position],Toast.LENGTH_LONG).show();
            }
        });
    }

    class CustomList extends ArrayAdapter<String> {

        private final Context context;
        private final String[] data;
        private final Integer[] imgid;

        CustomList(Context context, String[] data, Integer[] imgid) {
            super(context, R.layout.customlist, data);
            this.context=context;
            this.data=data;
            this.imgid=imgid;
        }


        public View getView(int i, View convertView, ViewGroup viewGroup){
            View v1 = getLayoutInflater().inflate(R.layout.customlist, viewGroup, false);

            ImageView imgv = v1.findViewById(R.id.img);
            TextView txtv = v1.findViewById(R.id.txt);

            imgv.setImageResource(imgid[i]);
            txtv.setText(data[i]);

            return v1;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id1 = item.getItemId();
        if (id1 == R.id.setting) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }}
