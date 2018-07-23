package com.test.animationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.test.animationtest.fragment_animation.FragmentAnimationActivity;
import com.test.animationtest.property_animation.PropertyAnimationActivity;
import com.test.animationtest.tween_animation.TweenAnimationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bt_zhen)
    Button mBtZhen;//帧动画

    @BindView(R.id.bt_bujian)
    Button mBtBuJian;//补间动画

    @BindView(R.id.bt_shuxing)
    Button mBtShuXin;//属性动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_zhen, R.id.bt_bujian, R.id.bt_shuxing})
    public void clickButton(View view) {
        switch (view.getId()) {
            case R.id.bt_zhen:
                startActivity(new Intent(this, FragmentAnimationActivity.class));
                break;
            case R.id.bt_bujian:
                startActivity(new Intent(this, TweenAnimationActivity.class));
                break;
            case R.id.bt_shuxing:
                startActivity(new Intent(this, PropertyAnimationActivity.class));
                break;
        }
    }
}
