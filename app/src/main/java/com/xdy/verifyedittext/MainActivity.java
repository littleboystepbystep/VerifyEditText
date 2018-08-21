package com.xdy.verifyedittext;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

public class MainActivity extends AppCompatActivity {

    private VerifyTextInputLayout layoutUsername;
    private VerifyTextInputLayout layoutPwd;
    private TextInputEditText etUsername;
    private TextInputEditText etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        layoutUsername = findViewById(R.id.layout_username);
        layoutPwd = findViewById(R.id.layout_pwd);
        etUsername = findViewById(R.id.et_username);
        etPwd = findViewById(R.id.et_pwd);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etUsername.getText().toString())) {
                    layoutUsername.startShakeAnimation();
                    return;
                }
                if (TextUtils.isEmpty(etPwd.getText().toString()))
                {
                    layoutPwd.startShakeAnimation();
                    return;
                }
                if (!"username".equals(etUsername.getText().toString()))
                {
                    layoutUsername.setHint("用户名错误");
                    layoutUsername.startShakeAnimation();
                    return;
                }
                if (!"pwd".equals(etPwd.getText().toString()))
                {
                    layoutPwd.setHint("密码错误");
                    layoutPwd.startShakeAnimation();
                    return;
                }
            }
        });

    }
}
