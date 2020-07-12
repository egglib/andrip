package com.egglib.andrip;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private TextView loadingView;
    private TextView mBtnClose;
    private String[] dots = {"", ".", ". .", ". . ."};
    private ValueAnimator valueAnimator;
    private String loadingTxt = "正在加载，请稍候";
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingView = (TextView) this.findViewById(R.id.loadingView);
        mBtnClose = (TextView) this.findViewById(R.id.btn_close);
        if (valueAnimator == null) {
            valueAnimator = ValueAnimator.ofInt(0, 4).setDuration(2000);
            valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int i = (int) animation.getAnimatedValue();
                    loadingView.setText(String.format("%s%s", loadingTxt, dots[i % dots.length]));
                }
            });
        }
        valueAnimator.start();

        mBtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueAnimator.cancel();
            }
        });

        viewFlipper = (ViewFlipper) findViewById(R.id.flipper);

        for (int i = 0; i < 5; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.layout_viewflipper, null);
            TextView textView = view.findViewById(R.id.tv_title);
            textView.setText("滚动" + i);
            viewFlipper.addView(view);

        }
    }
}
