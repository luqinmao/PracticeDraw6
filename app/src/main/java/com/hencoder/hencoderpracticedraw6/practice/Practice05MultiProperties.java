package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hencoder.hencoderpracticedraw6.R;
import com.hencoder.hencoderpracticedraw6.Utils;

public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt;
    ImageView imageView;
    private int translationState = 0;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，同时对多个属性做动画

                switch (translationState){
                    case 0:
                        imageView.animate()
                                .translationX(Utils.dpToPixel(200))
                                .alpha(1f)
                                .rotation(360)
                                .scaleY(1)
                                .scaleX(1)
                                .setDuration(500);
                        break;
                    case 1:
                        imageView.animate()
                                .translationX(Utils.dpToPixel(0))
                                .alpha(0f)
                                .rotation(0)
                                .scaleY(0)
                                .scaleX(0)
                                .setDuration(500);

                        break;
                }
                translationState ++;
                if (translationState == 2){
                    translationState = 0;
                }
            }
        });
    }
}
