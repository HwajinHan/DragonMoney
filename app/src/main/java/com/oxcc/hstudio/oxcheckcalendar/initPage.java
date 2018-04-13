package com.oxcc.hstudio.oxcheckcalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.view.View;

public class initPage extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 목표가 없는 경우(처음 실행시) init 페이지를 띄운다.
        // todo: 목표가 있는 경우는 첫페이지를 설정한 목표의 달력을 띄운다.
        setContentView(R.layout.page_init);

        Button btn_create = (Button)findViewById(R.id.btn_createNew);
        btn_create.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_createNew) {
            finish();
            Intent intent = new Intent(this, manageObject.class);//oxCheckCalendar.class);
            startActivity(intent);
        }
    }
}
