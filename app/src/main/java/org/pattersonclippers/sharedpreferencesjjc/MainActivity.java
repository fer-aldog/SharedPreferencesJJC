package org.pattersonclippers.sharedpreferencesjjc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button orangeBTN, blueBTN, greyBTN;
    TextView colorTV;
    LinearLayout backgroundLL;
    private SharedPreferences mySharedPreferences;
    SharedPreferences.Editor preferencesEditor;
    private String spFilename = "org.pattersonclippers.sharedpreferencesjjc";
    private final String COLOR_KEY = "color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialise shared preferences
        mySharedPreferences = getSharedPreferences(spFilename, MODE_PRIVATE);
        preferencesEditor = mySharedPreferences.edit();

        //read initial value for color from last time
        int initialColor = mySharedPreferences.getInt(COLOR_KEY, 0);

        orangeBTN = (Button) findViewById(R.id.orangeBTN);
        blueBTN = (Button) findViewById(R.id.blueBTN);
        greyBTN = (Button) findViewById(R.id.greyBTN);
        backgroundLL = (LinearLayout) findViewById(R.id.backgroundLL);
        colorTV = (TextView) findViewById(R.id.colorTV);

        //shows the color
        if(initialColor == R.color.pearl_orange){
            backgroundLL.setBackgroundColor(getResources().getColor(R.color.pearl_orange));
            colorTV.setTextColor(getResources().getColor(R.color.orange_bg));
        } else if (initialColor == R.color.azure_blue) {
            backgroundLL.setBackgroundColor(getResources().getColor(R.color.azure_blue));
            colorTV.setTextColor(getResources().getColor(R.color.blue_bg));
        } else if (initialColor == R.color.slate_grey) {
            backgroundLL.setBackgroundColor(getResources().getColor(R.color.slate_grey));
            colorTV.setTextColor(getResources().getColor(R.color.grey_bg));
        } else {
            backgroundLL.setBackgroundColor(getResources().getColor(R.color.bg));
            colorTV.setTextColor(getResources().getColor(R.color.black));
        }

        orangeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backgroundLL.setBackgroundColor(getResources().getColor(R.color.pearl_orange));
                colorTV.setTextColor(getResources().getColor(R.color.orange_bg));
                preferencesEditor.putInt(COLOR_KEY, R.color.pearl_orange);
                preferencesEditor.apply();
            }
        });

        blueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backgroundLL.setBackgroundColor(getResources().getColor(R.color.azure_blue));
                colorTV.setTextColor(getResources().getColor(R.color.blue_bg));
                preferencesEditor.putInt(COLOR_KEY, R.color.azure_blue);
                preferencesEditor.apply();
            }
        });

        greyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backgroundLL.setBackgroundColor(getResources().getColor(R.color.slate_grey));
                colorTV.setTextColor(getResources().getColor(R.color.grey_bg));
                preferencesEditor.putInt(COLOR_KEY, R.color.slate_grey);
                preferencesEditor.apply();
            }
        });

    }
}