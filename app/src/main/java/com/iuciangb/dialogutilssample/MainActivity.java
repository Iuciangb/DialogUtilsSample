package com.iuciangb.dialogutilssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogUtils.showOnlyAlertDialog(this, R.string.text_cancel, R.string.text_confirm);
    }
}
