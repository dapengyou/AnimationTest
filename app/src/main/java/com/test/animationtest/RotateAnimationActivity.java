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

       /*
       创建旋转动画的对象 & 设置动画效果：旋转动画对应的Animation子类为RotateAnimation
        RotateAnimation 有四种构造方法
        public RotateAnimation(Context context, AttributeSet attrs) {}

        public RotateAnimation(float fromDegrees, float toDegrees) {}

        public RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY) {}

        public RotateAnimation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) {}

         参数说明:
         1. fromDegrees ：动画开始时 视图的旋转角度(正数 = 顺时针，负数 = 逆时针)
         2. toDegrees ：动画结束时 视图的旋转角度(正数 = 顺时针，负数 = 逆时针)
         3. pivotXType：旋转轴点的x坐标的模式
         4. pivotXValue：旋转轴点x坐标的相对值
         5. pivotYType：旋转轴点的y坐标的模式
         6. pivotYValue：旋转轴点y坐标的相对值

         pivotXType = Animation.ABSOLUTE:旋转轴点的x坐标 =  View左上角的原点 在x方向 加上 pivotXValue数值的点(y方向同理)
         pivotXType = Animation.RELATIVE_TO_SELF:旋转轴点的x坐标 = View左上角的原点 在x方向 加上 自身宽度乘上pivotXValue数值的值(y方向同理)
         pivotXType = Animation.RELATIVE_TO_PARENT:旋转轴点的x坐标 = View左上角的原点 在x方向 加上 父控件宽度乘上pivotXValue数值的值 (y方向同理)

        */

        Animation animation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setDuration(3000);
        mIvImage.startAnimation(animation);
    }
}
