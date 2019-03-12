package com.example.databindingdemo.view;

import android.content.Context;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.util.AttributeSet;

import com.xw.repo.BubbleSeekBar;

/**
 * @author yanglijun
 * @date 19-3-12
 */
@InverseBindingMethods({@InverseBindingMethod(type = MySeekBar.class, attribute = "app:progress",
        event = "progressAttrChanged")})
public class MySeekBar extends BubbleSeekBar {
    public MySeekBar(Context context) {
        super(context);
    }

    public MySeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setProgressAttrChanged(final InverseBindingListener listener) {
        if (listener != null) {
            setOnProgressChangedListener(new OnProgressChangedListener() {
                @Override
                public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                    listener.onChange();
                }

                @Override
                public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress,
                                                  float progressFloat) {
                }

                @Override
                public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress,
                                                 float progressFloat, boolean fromUser) {
                }
            });
        }
    }
}
