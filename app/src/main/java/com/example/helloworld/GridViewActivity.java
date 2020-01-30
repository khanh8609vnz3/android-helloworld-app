package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    GridView gvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        initVar();
        main();
    }

    private void initVar() {
        gvName = findViewById(R.id.gridViewName);
    }

    private void main() {

        final ArrayList nameList = new ArrayList();

        for (int i = 1; i <= 20; i++) {
            nameList.add("Name " + i);
        }

        ArrayAdapter nameAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList);

        gvName.setAdapter(nameAdapter);

        gvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "Selected: "+nameList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
