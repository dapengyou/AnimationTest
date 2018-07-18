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

        /*
        创建透明度动画的对象 & 设置动画效果：透明度动画对应的Animation子类为AlphaAnimation
          AlphaAnimation 有两个构造方法
          public AlphaAnimation(Context context, AttributeSet attrs) {}

          public AlphaAnimation(float fromAlpha, float toAlpha) {}

         参数说明:
         1. fromAlpha:动画开始时视图的透明度(取值范围: -1 ~ 1)
         2. toAlpha:动画结束时视图的透明度(取值范围: -1 ~ 1)
        */
        Animation animation = new AlphaAnimation(1, 0);
        animation.setDuration(1000);
        animation.setRepeatCount(Animation.INFINITE);
        mIvImage.startAnimation(animation);
    }
}
