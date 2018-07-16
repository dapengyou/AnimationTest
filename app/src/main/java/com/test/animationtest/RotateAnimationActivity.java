package com.test.animationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class RotateAnimationActivity extends AppCompatActivity {
    private ImageView mIvImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_animation);
        mIvImage = findViewById(R.id.iv_image);
//        //传入xml
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
//        //开始动画
//        mIvImage.startAnimation(animation);

        Animation animation = new RotateAnimation(0, 360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setDuration(3000);
        mIvImage.startAnimation(animation);
    }
}
