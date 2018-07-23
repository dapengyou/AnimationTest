package com.test.animationtest.property_animation;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.test.animationtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ValueAnimatorActivity extends AppCompatActivity {
    @BindView(R.id.iv_image)
    ImageView mIvImage;

    @BindView(R.id.bt_value_int)
    Button mBtValueInt;

    @BindView(R.id.bt_value_float)
    Button mBtValueFloat;

    @BindView(R.id.bt_value_object)
    Button mBtValueObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);

        ButterKnife.bind(this);
    }


    @OnClick({R.id.bt_value_int, R.id.bt_value_float, R.id.bt_value_object})
    public void clickButton(View view) {
        switch (view.getId()) {
            case R.id.bt_value_int:
                Toast.makeText(this, "开始ValueInt动画", Toast.LENGTH_SHORT).show();
                valueInt();
                break;
            case R.id.bt_value_float:
                Toast.makeText(this, "开始ValueFloat动画", Toast.LENGTH_SHORT).show();
                valueFloat();
                break;
            case R.id.bt_value_object:
                startActivity(new Intent(this, ValueObjectActivity.class));
                break;
        }
    }

    private void valueInt() {
        //载入xml
//        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.value);
//        // 设置动画对象
//        valueAnimator.setTarget(mIvImage);

        ValueAnimator valueAnimator = ValueAnimator.ofInt(100, 200);
        valueAnimator.setDuration(3000);
        valueAnimator.setRepeatCount(Animation.INFINITE);

        //监听
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int currentValue = (Integer) valueAnimator.getAnimatedValue();
                // 获得每次变化后的属性值
                System.out.println(currentValue);
                // 输出每次变化后的属性值进行查看

                mIvImage.setImageAlpha(currentValue);

                // 每次值变化时，将值手动赋值给对象的属性
                // 即将每次变化后的值 赋 给按钮的宽度，这样就实现了按钮宽度属性的动态变化

                // 刷新视图，即重新绘制，从而实现动画效果
                mIvImage.requestLayout();
            }
        });
        //开始动画
        valueAnimator.start();
    }

    private void valueFloat() {
        //载入xml
//        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.value);
//        // 设置动画对象
//        valueAnimator.setTarget(mIvImage);

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(100, 200);
        valueAnimator.setDuration(3000);
        valueAnimator.setRepeatCount(Animation.INFINITE);

        //监听
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float currentValue = (float) valueAnimator.getAnimatedValue();
                // 获得每次变化后的属性值
                System.out.println(currentValue);
                // 输出每次变化后的属性值进行查看

                mIvImage.setImageAlpha((int) currentValue);

                // 每次值变化时，将值手动赋值给对象的属性
                // 即将每次变化后的值 赋 给按钮的宽度，这样就实现了按钮宽度属性的动态变化

                // 刷新视图，即重新绘制，从而实现动画效果
                mIvImage.requestLayout();
            }
        });
        //开始动画
        valueAnimator.start();
    }
}
