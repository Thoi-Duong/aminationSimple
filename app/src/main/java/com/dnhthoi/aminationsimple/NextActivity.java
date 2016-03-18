package com.dnhthoi.aminationsimple;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class NextActivity extends AppCompatActivity {
    long start;
    ImageView img;
    AnimationDrawable rocketAnimation;
    Button btnShow;
    TextView txtShowing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
                //btnShow.animate().translationY(0).setDuration(200).start();
                btnShow.animate().setListener(null);
                btnShow.animate().translationY(0).setDuration(100).start();
                btnShow.setVisibility(View.VISIBLE);

                txtShowing.animate().setListener(null);
                txtShowing.animate().translationY(50).setDuration(200).start();
                txtShowing.setVisibility(View.GONE);
            }
        });
        //playAnimation();

        btnShow = (Button) findViewById(R.id.btnshow);
        txtShowing = (TextView) findViewById(R.id.txt_showing);
        img = (ImageView) findViewById(R.id.imgNextAcitivityBackground2);

        img.setBackgroundResource(R.drawable.coin_next_activity);

        rocketAnimation = (AnimationDrawable) img.getBackground();
        rocketAnimation.setOneShot(false);
        img.setVisibility(View.GONE);


    }
    int cout = 0;
    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
        if(cout ==0) {
            //img.setVisibility(View.VISIBLE);
            img.post(new Runnable() {

                @Override
                public void run() {

                    rocketAnimation.start();
                }

            });

            final ImageView imageView = (ImageView) findViewById(R.id.imgBackground4);
            final Animation zoomin = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            zoomin.setDuration(300);
            start = System.currentTimeMillis();
            Log.e("tine Start::: ", "" + start);
            imageView.post(new Runnable() {
                @Override
                public void run() {
                    imageView.startAnimation(zoomin);
                    Log.e("current duaration", "" + zoomin.getDuration());
                }
            });


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    img.setVisibility(View.GONE);
                }
            }, 1000);
            cout--;

        }
            btnShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    txtShowing.setVisibility(View.VISIBLE);
                    btnShow.animate().translationY(-100).setDuration(300).setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            txtShowing.animate().translationY(-100).setDuration(350).setListener(new Animator.AnimatorListener() {
                                @Override
                                public void onAnimationStart(Animator animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    txtShowing.animate().setListener(null);
                                    txtShowing.animate().translationY(0).setDuration(0).start();
                                    btnShow.setVisibility(View.GONE);
                                }

                                @Override
                                public void onAnimationCancel(Animator animation) {

                                }

                                @Override
                                public void onAnimationRepeat(Animator animation) {

                                }
                            }).start();
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {

                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }

                    }).start();


                    //txtShowing.setVisibility(View.VISIBLE);

                }
            });



        }
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
                zoomin.setDuration(300);zoomin.setDuration(300);
                Log.e("current duaration", ""+zoomin.getDuration());
            }
        });
    }

}
