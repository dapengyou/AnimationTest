package com.test.animationtest;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class ScaleAnimationActivity extends AppCompatActivity {

    private ImageView mIvImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_animation);

        mIvImage = findViewById(R.id.iv_image);
//        //传入xml文件
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
//        //开始动画
//        mIvImage.startAnimation(animation);

        Animation animation = new ScaleAnimation(0, 5, 0, 5, 0.5f, 0.5f);
        animation.setDuration(3000);
        animation.setRepeatCount(Animation.INFINITE);
        mIvImage.startAnimation(animation);

    }
}
