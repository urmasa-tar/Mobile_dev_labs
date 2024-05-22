package com.example.myapp_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] r_str;
    String[] e_str;
    String[] com_p;
    String[] com_ch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listV = (ListView) findViewById(R.id.listV);
        r_str = getResources().getStringArray(R.array.rus_words);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, r_str);
        listV.setAdapter(adapter);

        e_str = getResources().getStringArray(R.array.engl_words);
        TextView txtV = (TextView)findViewById(R.id.txtV);
        txtV.setText(e_str[0]);

        com_p = r_str;
        com_ch = e_str;

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                // по позиции получаем выбранный элемент
                String selectedItem = com_ch[position];
                // установка текста элемента TextView

                Toast.makeText(getApplicationContext(), selectedItem,
                        Toast.LENGTH_SHORT).show();

            }
        });

    }

}