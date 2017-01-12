package com.example.xyzreader.ui;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Mahesh Gaya on 1/11/17.
 * Code and Idea: https://github.com/ianhanniballake/cheesesquare/blob/92bcf7c8b57459051424cd512a032c12d24a41b3/app/src/main/java/com/support/android/designlibdemo/ScrollAwareFABBehavior.java
 */

public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {
    private Context mContext;
    private AttributeSet mAttributeSet;
    private static final String TAG = ScrollAwareFABBehavior.class.getSimpleName();

    public ScrollAwareFABBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mContext = context;
        mAttributeSet = attributeSet;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
                || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }


    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        //Log.d(TAG, "onNestedScroll: " + dyConsumed);
        if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE) {
            //hide FAB while user scrolls down
            child.setVisibility(View.INVISIBLE);
        } else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {
            //Show FAB while user scrolls up
            child.setVisibility(View.VISIBLE);
        }
    }
}