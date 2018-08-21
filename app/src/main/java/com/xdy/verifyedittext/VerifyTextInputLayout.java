package com.xdy.verifyedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

/**
 * @Description: TODO
 * @author: xdy
 * @email: xdy@sinoroad.com
 * @Date: 2018/8/20 16:31
 */
public class VerifyTextInputLayout extends TextInputLayout {

    private static final int DEFAULT_SHAKE_TIME         = 100;          // 默认单次时长100ms
    private static final int DEFAULT_SHAKE_OFFSET       = 5;            // 默认偏移量5dp
    private static final int DEFAULT_SHAKE_REPEAT_COUNT = 5;            // 默认抖动次数

    private int shakeTime;
    private int shakeOffset;    // 抖动偏移量
    private int shakeRepeatCount;

    private TranslateAnimation animation;

    public VerifyTextInputLayout(Context context) {
        super(context);
        init(context, null);
    }

    public VerifyTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public VerifyTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        initAttrs(context, attrs);

        animation = (TranslateAnimation) AnimationUtils.loadAnimation(context, R.anim.anim_translate);
        animation.initialize(shakeOffset, 0, 0, 0);
        animation.setDuration(shakeTime);
        animation.setRepeatCount(shakeRepeatCount);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.VerifyTextInputLayout);
        shakeTime = typedArray.getInt(R.styleable.VerifyTextInputLayout_shake_single_time, DEFAULT_SHAKE_TIME);
        shakeOffset = typedArray.getDimensionPixelOffset(R.styleable.VerifyTextInputLayout_shake_offset, DEFAULT_SHAKE_OFFSET);
        shakeRepeatCount = typedArray.getInt(R.styleable.VerifyTextInputLayout_shake_repeat_count, DEFAULT_SHAKE_REPEAT_COUNT);
        typedArray.recycle();

    }

    public void startShakeAnimation() {
        if (animation != null) {
            // 获取焦点
            this.requestFocus();
            this.startAnimation(animation);
        }
    }
}
