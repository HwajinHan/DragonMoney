package com.oxcc.hstudio.oxcheckcalendar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;
import android.widget.Button;
//
import java.lang.Object;
import java.util.Date;


public class oxCheckCalendar extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ox_check_calendar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button button;
        // R
        TextView title;
        dateTextView col0, col1, col2, col3, col4, col5, col6;
        dateTextView date[][] = new dateTextView[6][7];
        String btnName;
        int resID;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                btnName = "row" + (i + 1) + "_col" + (j + 1);
                resID = getResources().getIdentifier(btnName, "id", getPackageName());
                date[i][j] = (dateTextView)findViewById(resID);
                date[i][j].setOnClickListener(this);
                date[i][j].setExampleColor(Color.BLUE);
                date[i][j].setExampleDimension(24);
            }
        }
        title = (TextView)findViewById(R.id.title);

        button=(Button)findViewById(R.id.btn_pre);

        col0 = (dateTextView)findViewById(R.id.row0_col1);
        col1 = (dateTextView)findViewById(R.id.row0_col2);
        col2 = (dateTextView)findViewById(R.id.row0_col3);
        col3 = (dateTextView)findViewById(R.id.row0_col4);
        col4 = (dateTextView)findViewById(R.id.row0_col5);
        col5 = (dateTextView)findViewById(R.id.row0_col6);
        col6 = (dateTextView)findViewById(R.id.row0_col7);


        // initialize
        title.setText("종우니 운동가야지");

        col0.setExampleString("일요일");
        col1.setExampleString("울요일");
        col2.setExampleString("화요일");
        col3.setExampleString("수요일");
        col4.setExampleString("목요일");
        col5.setExampleString("금요일");
        col6.setExampleString("일요일");
        button.setText("i made this");

        Date curDate = new Date();
        System.out.print(curDate);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.row1_col1:
            case R.id.row1_col2:
            case R.id.row1_col3:
            case R.id.row1_col4:
            case R.id.row1_col5:
            case R.id.row1_col6:
            case R.id.row1_col7:
                v.setBackgroundColor(Color.BLUE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ox_check_calendar, menu);
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
}
