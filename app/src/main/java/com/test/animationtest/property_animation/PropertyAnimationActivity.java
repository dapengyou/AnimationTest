package com.test.animationtest.property_animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.test.animationtest.R;
import com.test.animationtest.tween_animation.TranslateAnimationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 属性动画
 */
public class PropertyAnimationActivity extends AppCompatActivity {

    @BindView(R.id.bt_value_animator)
    Button mBtValueAnimator;

    @BindView(R.id.bt_object_animator)
    Button mBtObjectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_value_animator, R.id.bt_object_animator})
    public void clickButton(View view) {
        switch (view.getId()) {
            case R.id.bt_value_animator:
                startActivity(new Intent(this, ValueAnimatorActivity.class));

                break;
            case R.id.bt_object_animator:
                startActivity(new Intent(this, ObjectAnimatorActivity.class));

                break;
        }
    }
}
