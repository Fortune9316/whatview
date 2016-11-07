package com.izi.whatview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.LinearLayout;

/**
 * Created by JHON on 01/11/2016.
 */

public class CheckedLinearLayout extends LinearLayout implements Checkable {


    private boolean mChecked=false;


    private final int[] CHECKED_STATE_SET = {
            android.R.attr.state_checked
    };

    public CheckedLinearLayout(Context context) {
        super(context);
    }

    public CheckedLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void setChecked(boolean checked) {
        mChecked = checked;

        refreshDrawableState();
        invalidate();
    }


    @Override
    public boolean isChecked() {
        return mChecked;
    }


    @Override
    public void toggle() {
        setChecked(!mChecked);
    }


    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }
}
