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


        /*
        创建缩放动画的对象 & 设置动画效果：缩放动画对应的Animation子类为ScaleAnimation
        ScaleAnimation 有四种构造方法
     public ScaleAnimation(Context context, AttributeSet attrs) {}

         public ScaleAnimation(float fromX, float toX, float fromY, float toY) {}

         public ScaleAnimation(float fromX, float toX, float fromY, float toY, float pivotX, float pivotY) {}

         public ScaleAnimation(float fromX, float toX, float fromY, float toY, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) {}

         参数说明:
         1. fromX ：动画在水平方向X的结束缩放倍数
         2. toX ：动画在水平方向X的结束缩放倍数
         3. fromY ：动画开始前在竖直方向Y的起始缩放倍数
         4. toY：动画在竖直方向Y的结束缩放倍数
         5. pivotXType:缩放轴点的x坐标的模式
         6. pivotXValue:缩放轴点x坐标的相对值
         7. pivotYType:缩放轴点的y坐标的模式
         8. pivotYValue:缩放轴点y坐标的相对值

         pivotXType = Animation.ABSOLUTE:缩放轴点的x坐标 =  View左上角的原点 在x方向 加上 pivotXValue数值的点(y方向同理)
         pivotXType = Animation.RELATIVE_TO_SELF:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 自身宽度乘上pivotXValue数值的值(y方向同理)
         pivotXType = Animation.RELATIVE_TO_PARENT:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 父控件宽度乘上pivotXValue数值的值 (y方向同理)
         */

        Animation animation = new ScaleAnimation(0, 5, 0, 5, 0.5f, 0.5f);
        animation.setDuration(3000);
        animation.setRepeatCount(Animation.INFINITE);
        mIvImage.startAnimation(animation);

    }
}
