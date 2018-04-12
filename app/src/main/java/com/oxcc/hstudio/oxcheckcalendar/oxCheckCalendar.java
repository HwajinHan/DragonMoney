package com.oxcc.hstudio.oxcheckcalendar;

import android.os.Bundle;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Button;
//
import java.util.Date;


public class oxCheckCalendar extends AppCompatActivity implements View.OnClickListener {

    private dateTextView date[][] = new dateTextView[7][7];
    public Date curDate = new Date();
    public int curYear = curDate.getYear();
    public int curMonth = curDate.getMonth();
    public TextView textTitle, textMonth;

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
        Button btn_pre, btn_next;
        // R
        dateTextView col0, col1, col2, col3, col4, col5, col6;
        String btnName;
        int resID;

        int days = 1;
        int startDays = (new Date(curYear, curMonth, days).getDay());
        int endDay = getDaysInMonth(curYear, curMonth);

                //remove later
        TextView debug = (TextView)findViewById(R.id.debugtext);

        // 달력 상단
        textTitle = (TextView)findViewById(R.id.title);
        textMonth = (TextView)findViewById(R.id.month);
        btn_pre = (Button)findViewById(R.id.btn_pre);
        btn_next = (Button)findViewById(R.id.btn_next);

        btn_pre.setOnClickListener(this);
        btn_next.setOnClickListener(this);

        // 달력 내부
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                btnName = "row" + i + "_col" + (j + 1);
                resID = getResources().getIdentifier(btnName, "id", getPackageName());
                date[i][j] = (dateTextView)findViewById(resID);
                date[i][j].setOnClickListener(this);
                if (i == 0) {
                    date[i][j].setExampleColor(Color.WHITE);
                    date[i][j].setBackgroundColor(Color.RED);
                    date[i][j].setExampleDimension(50);

                } else {
                    date[i][j].setExampleColor(Color.BLUE);
                    date[i][j].setExampleDimension(40);
                    if (i == 1) {
                        if (j < startDays) {
                            //skip
                        } else {
                            date[i][j].setExampleString((String.format("%d", days)));
                            days++;
                        }
                    } else {
                        if (days <= endDay) {
                            date[i][j].setExampleString((String.format("%d", days)));
                            days++;
                        }
                    }
                }
            }
        }
        date[0][0].setExampleString("일요일");
        date[0][1].setExampleString("월요일");
        date[0][2].setExampleString("화요일");
        date[0][3].setExampleString("수요일");
        date[0][4].setExampleString("목요일");
        date[0][5].setExampleString("금요일");
        date[0][6].setExampleString("일요일");


        // initialize
        textTitle.setText("종우니 운동가야지");
        textMonth.setText((curDate.getMonth() + 1) + "월");
        debug.setText(getDaysInMonth(curDate.getYear(), curDate.getMonth()+1) + "일");



        System.out.print(curDate.toString());


    }
    private int getDaysInMonth(int year, int month) {
        return new Date(year, month, 0).getDate();
    }
    private void setMonthView(int year, int month) {
        String btnName;
        int resID;

        int days = 1;
        int startDays = (new Date(year, month, days)).getDay();
        int endDay = getDaysInMonth(year, month);

        textMonth.setText((curMonth + 1) + "월");

        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                btnName = "row" + i + "_col" + (j + 1);
                resID = getResources().getIdentifier(btnName, "id", getPackageName());
                date[i][j] = (dateTextView)findViewById(resID);

                if (i == 1) {
                    if (j < startDays) {
                        date[i][j].setExampleString("");
                        //skip
                    } else {
                        date[i][j].setExampleString((String.format("%d", days)));
                        days++;
                    }
                } else {
                    if (days <= endDay) {
                        date[i][j].setExampleString((String.format("%d", days)));
                        days++;
                    }
                }
                date[i][j].invalidate();
            }
        }

    }

    public void setMonth(boolean increase) {
        if(increase) {
            curMonth++;
            if(curMonth > 11) {
                curMonth = 0;
                curYear++;
            }
        } else {
            curMonth--;
            if (curMonth < 0) {
                curMonth = 11;
                curYear--;
            }
        }
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_pre:
                setMonth(false);
                setMonthView(curYear, curMonth);
                break;
            case R.id.btn_next:
                setMonth(true);
                setMonthView(curYear, curMonth);
                break;
            case R.id.row0_col1:
            case R.id.row0_col2:
            case R.id.row0_col3:
            case R.id.row0_col4:
            case R.id.row0_col5:
            case R.id.row0_col6:
            case R.id.row0_col7:
                break;
            default:
                dateTextView view = (dateTextView)v;
                view.checkAndSetStatus();
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
