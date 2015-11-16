package com.shcgroup.appportfolio;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class AppPortfolio extends AppCompatActivity {
    private List<Button> buttonList;
    @Bind(R.id.mainMenuButton1)
    Button mainButton1;
    @Bind(R.id.mainMenuButton2)
    Button mainButton2;
    @Bind(R.id.mainMenuButton3)
    Button mainButton3;
    @Bind(R.id.mainMenuButton4)
    Button mainButton4;
    @Bind(R.id.mainMenuButton5)
    Button mainButton5;
    @Bind(R.id.capstoneButton)
    Button capStoneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_portfolio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        createMainButtonList();
        final List<String> appNames = getAppNames();

        if (buttonList.size() == appNames.size()) {
            for (int i = 0; i < buttonList.size(); i++) {
                buttonList.get(i).setOnClickListener(new View.OnClickListener() {
                    private String appName;

                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "This is the " + appName, Toast.LENGTH_SHORT).show();
                    }

                    private View.OnClickListener init(String name) {
                        appName = name;
                        return this;
                    }
                }.init(appNames.get(i)));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_app_portfolio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createMainButtonList() {
        ButterKnife.bind(this);
        buttonList = Arrays.asList(mainButton1, mainButton2, mainButton3, mainButton4, mainButton5, capStoneButton);
    }

    private List<String> getAppNames() {
        return Arrays.asList("SPOTIFY STREAMER", "SCORES APP", "LIBRARY APP", "BUILDER BIGGER", "XYZ READER", "CAPSTONE PROJECT");
    }

}
