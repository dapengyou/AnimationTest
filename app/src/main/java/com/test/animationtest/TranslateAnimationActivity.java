package com.test.animationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class TranslateAnimationActivity extends AppCompatActivity {
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_animation);
        // 步骤1:创建 需要设置动画的 视图View
        mImageView = findViewById(R.id.iv_image);
//        // 步骤2:创建 动画对象 并传入设置的动画效果xml文件
//        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
//        // 步骤3:播放动画
//        mImageView.startAnimation(translateAnimation);
        Animation translateAnimation = new TranslateAnimation(0, 500, 0, 500);
        // 步骤2：创建平移动画的对象：平移动画对应的Animation子类为TranslateAnimation
        // 参数分别是：
        // 1. fromXDelta ：视图在水平方向x 移动的起始值
        // 2. toXDelta ：视图在水平方向x 移动的结束值
        // 3. fromYDelta ：视图在竖直方向y 移动的起始值
        // 4. toYDelta：视图在竖直方向y 移动的结束值

        // 固定属性的设置都是在其属性前加“set”，如setDuration（）
        translateAnimation.setDuration(3000);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        // 步骤3:播放动画
        mImageView.startAnimation(translateAnimation);
    }
}
