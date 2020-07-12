package com.egglib.andrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.egglib.andrip.MainActivity;
import com.egglib.andrip.R;
import com.egglib.andrip.progressview.OnFinishListener;
import com.egglib.andrip.progressview.ProgressView;

public class SplashActivity extends AppCompatActivity {

    private ProgressView mProgressView;
    private RelativeLayout mRlEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
    }

    private void initView() {
        mRlEnter = (RelativeLayout) findViewById(R.id.rl_enter);
        mProgressView = (ProgressView) findViewById(R.id.progress);

        //跳过的点击事件
        mRlEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterMain();
            }
        });

        //设置进度条颜色
        mProgressView.setPaintColor("#ff0000");
        //开始倒计时
        mProgressView.startDownTime(4000, new OnFinishListener() {
            @Override
            public void onFinish() {
//                enterMain();
            }
        });
    }

    private void enterMain(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
