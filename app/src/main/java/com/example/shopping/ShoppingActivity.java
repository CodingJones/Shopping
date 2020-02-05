package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShoppingActivity extends AppCompatActivity {

    // GUI variables
    private Button listItems;
    private Button addNewItem;

    private TextView items;
    private TextView whatItem;
    private TextView where;

    private EditText editWhat;
    private EditText editWhere;

    // Model: Database of items
    private ItemsDB itemsDB;

    //private Item item;
    private String addItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping);
        itemsDB = new ItemsDB();
        itemsDB.fillItemsDB();

        items = (TextView) findViewById(R.id.items);

        whatItem = (TextView) findViewById(R.id.whatItem);
        editWhat = (EditText) findViewById(R.id.editWhatItem);

        where = (TextView) findViewById(R.id.where);
        editWhere = (EditText) findViewById(R.id.editWhere);

        addNewItem = (Button) findViewById(R.id.add_new_item);
        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItems = editWhat.getText().toString();
                addItems = editWhere.getText().toString();
            }
        });

        listItems = (Button) findViewById(R.id.list_items);
        listItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.setBackgroundColor(Color.parseColor("#FFFFFF"));
                items.setText("Shopping List:" + itemsDB.listItems());
            }
        });
    }
}
