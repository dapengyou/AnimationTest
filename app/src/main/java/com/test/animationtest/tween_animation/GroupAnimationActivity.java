package com.test.animationtest.tween_animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.test.animationtest.R;

public class GroupAnimationActivity extends AppCompatActivity {
    private ImageView mIvImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_animation);

        mIvImage = findViewById(R.id.iv_image);

//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.group);
//        mIvImage.startAnimation(animation);

        // 组合动画设置
        // 步骤1:创建组合动画对象(设置为true)
        AnimationSet setAnimation = new AnimationSet(true);
        // 步骤2:设置组合动画的属性
        setAnimation.setRepeatMode(Animation.RESTART);
        setAnimation.setStartOffset(1000);
        setAnimation.setDuration(3000);

        // 步骤3:逐个创建子动画(方式同单个动画创建方式,此处不作过多描述)

        // 子动画1:旋转动画
        Animation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(3000);
        rotate.setRepeatMode(Animation.RESTART);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setStartOffset(100);

        // 子动画2:平移动画
        Animation translate = new TranslateAnimation(0, 500, 0, 500);
        translate.setDuration(1000);
        rotate.setStartOffset(0);


        // 子动画3:透明度动画
        Animation alpha = new AlphaAnimation(1, 0);
        alpha.setDuration(5000);
        alpha.setStartOffset(2000);


        // 步骤4:将创建的子动画添加到组合动画里
        setAnimation.addAnimation(rotate);
        setAnimation.addAnimation(translate);
        setAnimation.addAnimation(alpha);

        // 步骤5:播放动画
        mIvImage.startAnimation(setAnimation);

    }
}
