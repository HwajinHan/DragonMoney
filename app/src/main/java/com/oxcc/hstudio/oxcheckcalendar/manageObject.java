package com.oxcc.hstudio.oxcheckcalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class manageObject extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_manage_aim);

        Button btn_gotoCalendar = (Button)findViewById(R.id.btn_gotoCalendar);
        btn_gotoCalendar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_gotoCalendar:
                finish();
                Intent intent = new Intent(this, oxCheckCalendar.class);//oxCheckCalendar.class);
                startActivity(intent);
                break;
        }
    }
}
