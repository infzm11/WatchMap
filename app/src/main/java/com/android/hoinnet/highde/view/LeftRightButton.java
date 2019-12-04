package com.android.hoinnet.highde.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.hoinnet.highde.R;

public class LeftRightButton extends LinearLayout implements View.OnClickListener {
    private final int BUTTON_TYPE_IMG;
    private Context mContext;
    private LinearLayout mLayoutLeft;
    private LinearLayout mLayoutRight;
    private Drawable mLeftDrawableBg;
    private Drawable mLeftDrawableImg;
    private ImageView mLeftImg;
    private LeftRightListener mLeftRightListener;
    private String mLeftText;
    private TextView mLeftTv;
    private Resources mRes;
    private Drawable mRightDrawableBg;
    private Drawable mRightDrawableImg;
    private ImageView mRightImg;
    private String mRightText;
    private TextView mRightTv;
    private int mType;

    public interface LeftRightListener {
        void onLeftClick(View view);

        void onRightClick(View view);
    }

    public LeftRightButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public LeftRightButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LeftRightButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BUTTON_TYPE_IMG = 1;
        this.mType = 1;
        this.mContext = context;
        this.mRes = getResources();
        LayoutInflater.from(context).inflate(R.layout.left_right_layout, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LeftRightView);
        this.mLeftDrawableBg = obtainStyledAttributes.getDrawable(0);
        this.mRightDrawableBg = obtainStyledAttributes.getDrawable(4);
        this.mType = obtainStyledAttributes.getInt(2, 1);
        this.mLeftDrawableImg = obtainStyledAttributes.getDrawable(1);
        this.mRightDrawableImg = obtainStyledAttributes.getDrawable(5);
        this.mLeftText = obtainStyledAttributes.getString(3);
        this.mRightText = obtainStyledAttributes.getString(6);
        obtainStyledAttributes.recycle();
        this.mLayoutLeft = (LinearLayout) findViewById(R.id.lr_cancel);
        this.mLayoutRight = (LinearLayout) findViewById(R.id.lr_confrim);
        this.mLayoutLeft.setBackground(this.mLeftDrawableBg);
        this.mLayoutRight.setBackground(this.mRightDrawableBg);
        this.mLeftImg = (ImageView) findViewById(R.id.lr_left_img);
        this.mRightImg = (ImageView) findViewById(R.id.lr_right_img);
        this.mLeftTv = (TextView) findViewById(R.id.lr_left_tv);
        this.mRightTv = (TextView) findViewById(R.id.lr_right_tv);
        if (this.mType == 1) {
            this.mLeftTv.setVisibility(8);
            this.mRightTv.setVisibility(8);
            this.mLeftImg.setVisibility(0);
            this.mRightImg.setVisibility(0);
            this.mLeftImg.setImageDrawable(this.mLeftDrawableImg);
            this.mRightImg.setImageDrawable(this.mRightDrawableImg);
        } else {
            this.mLeftTv.setVisibility(0);
            this.mRightTv.setVisibility(0);
            this.mLeftImg.setVisibility(8);
            this.mRightImg.setVisibility(8);
            this.mLeftTv.setText(this.mLeftText);
            this.mRightTv.setText(this.mRightText);
        }
        this.mLayoutLeft.setOnClickListener(this);
        this.mLayoutRight.setOnClickListener(this);
    }

    public void setLeftRightListener(LeftRightListener leftRightListener) {
        if (leftRightListener != null) {
            this.mLeftRightListener = leftRightListener;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lr_cancel:
                if (this.mLeftRightListener != null) {
                    this.mLeftRightListener.onLeftClick(view);
                    return;
                }
                return;
            case R.id.lr_confrim:
                if (this.mLeftRightListener != null) {
                    this.mLeftRightListener.onRightClick(view);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
