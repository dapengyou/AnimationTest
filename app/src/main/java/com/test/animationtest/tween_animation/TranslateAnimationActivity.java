package com.test.animationtest.tween_animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.test.animationtest.R;

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

        /*
         创建平移动画的对象：平移动画对应的Animation子类为TranslateAnimation
         TranslateAnimation 有三个构造方法
         public TranslateAnimation(Context context, AttributeSet attrs) {}

         public TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {}

         public TranslateAnimation(int fromXType, float fromXValue, int toXType, float toXValue, int fromYType, float fromYValue, int toYType, float toYValue) {}

         参数分别是：
         1. fromXDelta ：视图在水平方向x 移动的起始值
         2. toXDelta ：视图在水平方向x 移动的结束值
         3. fromYDelta ：视图在竖直方向y 移动的起始值
         4. toYDelta：视图在竖直方向y 移动的结束值
         5. pivotXType:平移轴点的x坐标的模式
         6. pivotXValue:平移轴点x坐标的相对值
         7. pivotYType:平移轴点的y坐标的模式
         8. pivotYValue:平移轴点y坐标的相对值
        */
        Animation translateAnimation = new TranslateAnimation(0, 500, 0, 500);

        // 固定属性的设置都是在其属性前加“set”，如setDuration（）
        translateAnimation.setDuration(3000);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        // 步骤3:播放动画
        mImageView.startAnimation(translateAnimation);

        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                    //动画开始时执行
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画取消时执行
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重复时执行
            }
        });
    }
}
