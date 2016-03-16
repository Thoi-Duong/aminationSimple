package com.dnhthoi.aminationsimple;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Objects;

public class NextActivity extends AppCompatActivity {
    long start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        playAnimation();
    }
    int cout = 0;
    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if(cout ==0)

        cout--;
    }

    void playAnimation(){


        final Dialog dialog = new Dialog(this);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog);
        final ImageView img = (ImageView) dialog.findViewById(R.id.imgAnimate);
        img.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable) img.getDrawable()).start();
            }
        });
        final ImageView imageView = (ImageView) findViewById(R.id.imgBackground4);
        final Animation zoomin = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        dialog.show();
        zoomin.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                start = System.currentTimeMillis() - start;
                Log.e("tineEnd::: ", "" + start);
                dialog.dismiss();
                dialog.cancel();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        //  imageView.setAnimation(zoomin);
        zoomin.setDuration(300);
        start = System.currentTimeMillis();
        Log.e("tine Start::: ", "" + start);
        imageView.post(new Runnable() {
            @Override
            public void run() {
                imageView.startAnimation(zoomin);
                Log.e("current duaration", ""+zoomin.getDuration());
            }
        });
    }

}
