package com.android.kusitms.kbscilpoon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

public class FoldingCellView extends RelativeLayout {

    private View mBackView;
    private View mFrontView;

    public FoldingCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(layoutParams);
        this.setClipToPadding(false);
        this.setClipChildren(false);
    }

    public FoldingCellView(View frontView, View backView, Context context) {
        super(context);
        this.mFrontView = frontView;
        this.mBackView = backView;

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        this.setClipToPadding(false);
        this.setClipChildren(false);

        if (mBackView != null) {
            this.addView(mBackView);
            RelativeLayout.LayoutParams mBackViewParams = (RelativeLayout.LayoutParams) mBackView.getLayoutParams();
            mBackViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            mBackView.setLayoutParams(mBackViewParams);
            layoutParams.height = mBackViewParams.height;
        }

        if (mFrontView != null) {
            this.addView(mFrontView);
            RelativeLayout.LayoutParams frontViewLayoutParams = (RelativeLayout.LayoutParams) mFrontView.getLayoutParams();
            frontViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            mFrontView.setLayoutParams(frontViewLayoutParams);
        }

        this.setLayoutParams(layoutParams);
    }

    public FoldingCellView withFrontView(View frontView) {
        this.mFrontView = frontView;

        if (mFrontView != null) {
            this.addView(mFrontView);
            RelativeLayout.LayoutParams frontViewLayoutParams = (RelativeLayout.LayoutParams) mFrontView.getLayoutParams();
            frontViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            mFrontView.setLayoutParams(frontViewLayoutParams);
        }
        return this;
    }

    public FoldingCellView withBackView(View backView) {
        this.mBackView = backView;

        if (mBackView != null) {
            this.addView(mBackView);
            RelativeLayout.LayoutParams mBackViewParams = (RelativeLayout.LayoutParams) mBackView.getLayoutParams();
            mBackViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            mBackView.setLayoutParams(mBackViewParams);

            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.getLayoutParams();
            layoutParams.height = mBackViewParams.height;
            this.setLayoutParams(layoutParams);
        }

        return this;
    }

    public View getBackView() {
        return mBackView;
    }

    public View getFrontView() {
        return mFrontView;
    }

    public void animateFrontView(Animation animation) {
        if (this.mFrontView != null)
            mFrontView.startAnimation(animation);
    }

}
