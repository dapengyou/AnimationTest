package com.test.animationtest.tween_animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.test.animationtest.R;

public class ChangeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.overridePendingTransition(0, R.anim.anim_bottom_out);
    }
}