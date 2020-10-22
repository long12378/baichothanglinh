package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ConstraintLayout manhinh;
    ListView list;
    ArrayList<String> nhac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manhinh = (ConstraintLayout) findViewById(R.id.manhinh);
        list = (ListView) findViewById(R.id.listView);
        nhac = new ArrayList<>();
        nhac.add("Dethsupport");
        nhac.add("through the fire and flames");
        nhac.add("Skyhunter");
        nhac.add("Impeach God");
        nhac.add("Beach house");
        nhac.add("Go forth and die");
        nhac.add("My name is murder");
        nhac.add("Thunderstruck");
        nhac.add("Master of the pupet");
        nhac.add("The way of Viking");
        nhac.add("Burn the eath");;
        nhac.add("Murmaider");
        nhac.add("Andromeda");
        nhac.add("Bloodline");
        nhac.add("The gear");
        nhac.add("Blazing star");


        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, nhac);

        list.setAdapter(adapter);
//        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                String itemString=list.getSelectedItem().toString();
//                return true;
//            }
//        });
        registerForContextMenu(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.them :
                Intent intent = new Intent(MainActivity.this, ThemActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("options");
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()){
            case R.id.sua :
                Intent intent2 = new Intent(MainActivity.this, SuaActivity.class);
                startActivity(intent2);
                break;
            case R.id.xoa :
//                Toast.makeText(MainActivity.this, "option",Toast.LENGTH_SHORT).show();
                nhac.remove(info.position);
                break;
            default:break;
        }
        return super.onContextItemSelected(item);
    }
}