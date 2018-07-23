package com.test.animationtest.property_animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import com.test.animationtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ObjectAnimatorActivity extends AppCompatActivity {
    @BindView(R.id.bt_translate)
    Button mBtTranslate;

    @BindView(R.id.bt_rotate)
    Button mBtRotate;

    @BindView(R.id.bt_scale)
    Button mBtScale;

    @BindView(R.id.bt_alpha)
    Button mBtAlpha;

    @BindView(R.id.bt_animator_set)
    Button mBtSet;

    @BindView(R.id.iv_image)
    ImageView mIvImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);

        ButterKnife.bind(this);

    }

    @OnClick({R.id.bt_translate, R.id.bt_rotate, R.id.bt_scale, R.id.bt_alpha,R.id.bt_animator_set})
    public void clickButton(View view) {
        switch (view.getId()) {
            case R.id.bt_translate:
                startTranslate();
                break;
            case R.id.bt_rotate:
                startRotate();
                break;
            case R.id.bt_scale:
                startScale();
                break;
            case R.id.bt_alpha:
                startAlpha();
                break;
            case R.id.bt_animator_set:
                startAnimatorSet();
                break;
        }
    }

    /**
     * 开始平移动画
     */
    private void startTranslate() {
//        Animator objectAnimator = AnimatorInflater.loadAnimator(this, R.animator.object_animator);
//        objectAnimator.setTarget(mIvImage);
//        objectAnimator.start();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIvImage, "translationX", 0f, 500f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mIvImage, "translationY", 0f, 500f);

        objectAnimator.setDuration(3000);
        objectAnimator1.setDuration(3000);

        objectAnimator.setRepeatCount(Animation.INFINITE);
        objectAnimator1.setRepeatCount(Animation.INFINITE);

        objectAnimator.start();
        objectAnimator1.start();
    }

    /**
     * 开始旋转动画
     */
    private void startRotate() {
//        Animator objectAnimator = AnimatorInflater.loadAnimator(this, R.animator.object_rotate);
//        objectAnimator.setTarget(mIvImage);
//        objectAnimator.start();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIvImage, "Rotation", 0f, 360f);

        objectAnimator.setDuration(3000);
        objectAnimator.setRepeatCount(Animation.INFINITE);

        objectAnimator.start();
    }

    /**
     * 开始缩放动画
     */
    private void startScale() {
//        Animator objectAnimator = AnimatorInflater.loadAnimator(this, R.animator.object_scale);
//        objectAnimator.setTarget(mIvImage);
//        objectAnimator.start();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIvImage, "scaleX", 1f, 5f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mIvImage, "scaleY", 1f, 5f);

        objectAnimator.setDuration(3000);
        objectAnimator1.setDuration(3000);

        objectAnimator.setRepeatCount(Animation.INFINITE);
        objectAnimator1.setRepeatCount(Animation.INFINITE);

        objectAnimator.start();
        objectAnimator1.start();
    }

    /**
     * 开始透明度动画
     */
    private void startAlpha() {
//        Animator objectAnimator = AnimatorInflater.loadAnimator(this, R.animator.object_alpha);
//        objectAnimator.setTarget(mIvImage);
//        objectAnimator.start();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIvImage, "alpha", 0f, 1f);

        objectAnimator.setDuration(3000);
        objectAnimator.setRepeatCount(Animation.INFINITE);

        objectAnimator.start();
    }

    /**
     * 开始组合动画
     */
    private void startAnimatorSet() {
        // 1、设置需要组合的动画效果
        // 平移动画
        ObjectAnimator translationX = ObjectAnimator.ofFloat(mIvImage, "translationX", 0f, 500f);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(mIvImage, "translationY", 0f, 500f);

        translationX.setRepeatCount(Animation.INFINITE);
        translationY.setRepeatCount(Animation.INFINITE);

        // 旋转动画
        ObjectAnimator rotate = ObjectAnimator.ofFloat(mIvImage, "rotation", 0f, 360f);

        rotate.setRepeatCount(Animation.INFINITE);

        //缩放动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mIvImage, "scaleX", 1f, 5f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mIvImage, "scaleY", 1f, 5f);

        scaleX.setRepeatCount(Animation.INFINITE);
        scaleY.setRepeatCount(Animation.INFINITE);

        // 透明度动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mIvImage, "alpha", 0f, 1f);

        alpha.setRepeatCount(Animation.INFINITE);

        //2、创建组合动画的对象
        AnimatorSet animSet = new AnimatorSet();

        // 3、根据需求组合动画
        animSet.playTogether(translationX, translationY, rotate, scaleX, scaleY, alpha);
        animSet.setDuration(3000);

        // 4、启动动画
        animSet.start();
    }

}
