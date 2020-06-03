package com.example.guiaparis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SelectionActivity extends AppCompatActivity {
    Spinner mySpinner;
    ArrayAdapter<String> myAdapter;

    public Spinner getSpinner() {return mySpinner;}

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        mySpinner = (Spinner) findViewById(R.id.spinner);
        myAdapter = new ArrayAdapter<String>(SelectionActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Locations));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        Button myButton = (Button) findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent myIntent = new Intent (SelectionActivity.this, MainActivity.class);
                Spinner thisSpinner = getSpinner();
                String text = thisSpinner.getSelectedItem().toString();

                if(text.equals("Torre Eifel")){
                    myIntent.putExtra("Lat", "40.850547");
                    myIntent.putExtra("Long", "2.294546");
                    myIntent.putExtra("name", "Torre Eifel");
                    startActivity(myIntent);
                }
                else if (text.equals("Trocadero")){
                    myIntent.putExtra("Lat", "40.863017");
                    myIntent.putExtra("Long", "2.207107");
                    myIntent.putExtra("name", "Trocadero");
                    startActivity(myIntent);

                }

            }
        });


    }
}
