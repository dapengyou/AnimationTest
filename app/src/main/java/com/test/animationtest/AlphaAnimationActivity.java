package com.test.animationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AlphaAnimationActivity extends AppCompatActivity {
    private ImageView mIvImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_animation);

        mIvImage = findViewById(R.id.iv_image);
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
//        mIvImage.startAnimation(animation);

        Animation animation = new AlphaAnimation(1, 0);
        animation.setDuration(3000);
        mIvImage.startAnimation(animation);
    }
}
