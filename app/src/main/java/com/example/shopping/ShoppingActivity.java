package com.example.shopping;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShoppingActivity extends AppCompatActivity {

    // GUI variables
    private Button listItems;
    private Button addNewItem;
    private TextView items;
    private EditText editWhat;
    private EditText editWhere;

    // Model: Database of items
    private ItemsDB itemsDB;

    /**
     * Creates the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping);
        itemsDB = new ItemsDB();
        itemsDB.fillItemsDB();

        items = (TextView) findViewById(R.id.items);
        editWhat = (EditText) findViewById(R.id.editWhatItem);
        editWhere = (EditText) findViewById(R.id.editWhere);

        addNewItemButton();

        listItemsButton();
    }

    /**
     * Button which on click lists all items in database.
     */
    private void listItemsButton() {
        listItems = (Button) findViewById(R.id.list_items);
        listItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.setBackgroundColor(Color.parseColor("#FFFFFF"));
                items.setText("Shopping List:" + itemsDB.listItems());
            }
        });
    }

    /**
     * Button which on click adds new item to database and provides user feedback.
     */
    private void addNewItemButton() {
        addNewItem = (Button) findViewById(R.id.add_new_item);
        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringWhat = editWhat.getText().toString();
                String stringWhere = editWhere.getText().toString();

                if (stringWhat.isEmpty() || stringWhere.isEmpty()) {
                    checkInput(false);
                } else {
                    itemsDB.addItem(stringWhat, stringWhere);
                    checkInput(true);
                }
            }
        });
    }

    /**
     * Informs the user by making a toast.
     *
     * @param userPressedNewItem
     */
    private void checkInput(boolean userPressedNewItem) {
        int messageResId = 0;

        if (userPressedNewItem) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

}
