package com.test.animationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TweenAnimationActivity extends AppCompatActivity {
    @BindView(R.id.translate)
    Button mBtTranslate;

    @BindView(R.id.scale)
    Button mBtScale;

    @BindView(R.id.rotate)
    Button mBtRotate;

    @BindView(R.id.alpha)
    Button mBtAlpha;

    @BindView(R.id.group)
    Button mBtGroup;

    @BindView(R.id.change_activity)
    Button mBtChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.translate, R.id.scale, R.id.rotate, R.id.alpha, R.id.group, R.id.change_activity})
    public void onClickButton(View view) {
        switch (view.getId()) {
            case R.id.translate:
                startActivity(new Intent(this, TranslateAnimationActivity.class));
                break;
            case R.id.scale:
                startActivity(new Intent(this, ScaleAnimationActivity.class));
                break;
            case R.id.rotate:
                startActivity(new Intent(this, RotateAnimationActivity.class));
                break;
            case R.id.alpha:
                startActivity(new Intent(this, AlphaAnimationActivity.class));
                break;
            case R.id.group:
                startActivity(new Intent(this, GroupAnimationActivity.class));
                break;
            case R.id.change_activity:
                startActivity(new Intent(this, ChangeActivity.class));

               /*
                 enterAnim：从Activity a跳转到Activity b，进入b时的动画效果资源ID
                 exitAnim：从Activity a跳转到Activity b，离开a时的动画效果资源Id
                 overridePendingTransition（）必须要在startActivity(intent)后被调用才能生效
                */
                this.overridePendingTransition(R.anim.anim_bottom_in, 0);
                break;
        }
    }
}
