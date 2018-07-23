package com.test.animationtest.fragment_animation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.test.animationtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentAnimationActivity extends AppCompatActivity {
    @BindView(R.id.bt_start)
    Button mBtStart;

    @BindView(R.id.bt_stop)
    Button mBtStop;

    @BindView(R.id.iv_image)
    ImageView mIvImage;

    private AnimationDrawable mAnimationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhen_animation);

        ButterKnife.bind(this);

//        mAnimationDrawable = new AnimationDrawable();
//        for (int i = 1; i <= 5; i++) {
//            int sourceId = getResources().getIdentifier("ic_heart_" + i, "drawable", getPackageName());
//            Drawable drawable = getResources().getDrawable(sourceId);
//            mAnimationDrawable.addFrame(drawable, 500);
//        }
    }

    @OnClick({R.id.bt_start, R.id.bt_stop})
    public void clickButton(View view) {
        switch (view.getId()) {
            case R.id.bt_start:
//                设置动画
                mIvImage.setImageResource(R.drawable.fragment_animation);
//                获取动画对象
                mAnimationDrawable = (AnimationDrawable) mIvImage.getDrawable();
//                开始动画
                mAnimationDrawable.start();
//                mAnimationDrawable.setOneShot(true);
//                mIvImage.setImageDrawable(mAnimationDrawable);
//                mAnimationDrawable.stop();
//                mAnimationDrawable.start();

                break;
            case R.id.bt_stop:
//                设置动画
                mIvImage.setImageResource(R.drawable.fragment_animation);
//                获取动画对象
                mAnimationDrawable = (AnimationDrawable) mIvImage.getDrawable();
//                停止动画
                mAnimationDrawable.stop();

//                mAnimationDrawable.setOneShot(true);
//
//                mIvImage.setImageDrawable(mAnimationDrawable);
//                mAnimationDrawable.stop();

                break;
        }
    }
}
