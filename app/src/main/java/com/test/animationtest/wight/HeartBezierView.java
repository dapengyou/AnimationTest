package com.test.animationtest.wight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.test.animationtest.R;

import java.util.Random;

public class HeartBezierView extends RelativeLayout implements View.OnClickListener {
    private Paint mPaint;
    private Path mPath;
    private Random mRandom;
    private Bitmap mBitmap;

    //记录屏幕的宽，高
    private int mScreenWidth;
    private int mScreenHeight;

    //记录数据点，控制点(由于是三阶贝塞尔曲线，所以有2个控制点)
    protected Point mStartPoint;
    protected Point mEndPoint;
    protected Point mConOnePoint;
    protected Point mConTwoPoint;

    protected int[] mColors = {Color.BLUE, Color.CYAN, Color.GREEN, Color.RED, Color.MAGENTA, Color.YELLOW};


    public HeartBezierView(Context context) {
        super(context);
        initView();

    }

    public HeartBezierView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    public HeartBezierView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);

        mPath = new Path();

        mRandom = new Random();

        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.heart);

        setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        this.mScreenHeight = height;
        this.mScreenWidth = width;

        mStartPoint = new Point(mScreenWidth / 2, 0);
        mEndPoint = new Point(mScreenWidth / 2, mScreenHeight);
        mConOnePoint = new Point(mScreenWidth, mScreenHeight * 3 / 4);
        mConTwoPoint = new Point(0, mScreenHeight / 4);

        setBackgroundColor(Color.WHITE);

    }

    //自定义TypeEvaluator
    class MyTypeEvaluator implements TypeEvaluator<Point> {
        private Point conOnePoint, conTwoPoint;

        public MyTypeEvaluator(Point conOnePoint, Point conTwoPoint) {
            this.conOnePoint = conOnePoint;
            this.conTwoPoint = conTwoPoint;
        }

        // 三阶贝塞尔曲线公式：       B(t)=(1-t)^3*p0+3*(1-t)^2*t*p1+3*(1-t)*t^2*p2+t^3*p3
        @Override
        public Point evaluate(float v, Point startPoint, Point endPoint) {
            int x = (int) ((Math.pow((1 - v), 3) * startPoint.x) + 3 * (Math.pow((1 - v), 2)) * v * conOnePoint.x +
                    3 * (1 - v) * (Math.pow(v, 2)) * conTwoPoint.x + (Math.pow(v, 3)) * endPoint.x);
            int y = (int) ((Math.pow((1 - v), 3) * startPoint.y) + 3 * (Math.pow((1 - v), 2)) * v * conOnePoint.y +
                    3 * (1 - v) * (Math.pow(v, 2)) * conTwoPoint.y + (Math.pow(v, 3)) * endPoint.y);
            return new Point(x, y);
        }
    }

    /**
     * 监听onTouch事件，动态生成对应坐标
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mStartPoint = new Point(mScreenWidth / 2, mScreenHeight);
        mEndPoint = new Point((int) (mScreenWidth / 2 + 150 * mRandom.nextFloat()), 0);
        mConOnePoint = new Point((int) (mScreenWidth * mRandom.nextFloat()), (int) (mScreenHeight * 3 * mRandom.nextFloat() / 4));
        mConTwoPoint = new Point(0, (int) (mScreenHeight * mRandom.nextFloat() / 4));

        addStar();
        return true;
    }

    protected void addStar() {
        Bitmap starBitmap = drawStar(mColors[mRandom.nextInt(mColors.length)]);
        final ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new LayoutParams(120, 100);
        layoutParams.addRule(CENTER_HORIZONTAL);
        layoutParams.addRule(ALIGN_PARENT_BOTTOM);
        imageView.setImageBitmap(starBitmap);
        addView(imageView, layoutParams);


        Point conOnePoint = this.mConOnePoint;
        Point conTwoPoint = this.mConTwoPoint;
        Point startPoint = this.mStartPoint;
        Point endPoint = this.mEndPoint;


        //设置属性动画
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new MyTypeEvaluator(conOnePoint, conTwoPoint), startPoint,
                endPoint);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();
                imageView.setX(point.x);
                imageView.setY(point.y);
            }
        });

        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                HeartBezierView.this.removeView(imageView);
            }
        });


        //透明度动画
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0f);

        //组合动画
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(4000);
        animatorSet.play(valueAnimator).with(objectAnimator);
        animatorSet.start();


        valueAnimator.start();
    }

    /**
     * 画星星并随机赋予不同的颜色
     *
     * @param color
     * @return
     */
    private Bitmap drawStar(int color) {
        //创建和资源文件Bitmap相同尺寸的Bitmap填充Canvas
        Bitmap outBitmap = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(outBitmap);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        //利用Graphics中的XferModes对Canvas进行着色
        canvas.drawColor(color, PorterDuff.Mode.SRC_IN);
        canvas.setBitmap(null);
        return outBitmap;
    }

}
