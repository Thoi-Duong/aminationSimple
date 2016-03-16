package com.dnhthoi.aminationsimple;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    ImageView imgBackgound1;
    ImageView imgBackgound2;
    ImageView imgBackgound3;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        dialog = new Dialog(this);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog);

        final ImageView img = (ImageView) dialog.findViewById(R.id.imgAnimate);
        imgBackgound1 = (ImageView) findViewById(R.id.imgBackground1);
        imgBackgound2 = (ImageView) findViewById(R.id.imgBackground2);
        imgBackgound3 = (ImageView) findViewById(R.id.imgBackground3);
        img.post(new Runnable() {

            @Override
            public void run() {
                ((AnimationDrawable) img.getDrawable()).start();
            }

        });


        fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
//                AnimatorSet mAnimationSet = new AnimatorSet();
//                ObjectAnimator fadeOut = ObjectAnimator.ofFloat(imgBackgound1, View.TRANSLATION_X,  0, -2 * imgBackgound1.getWidth());
//                fadeOut.addListener(new Animator.AnimatorListener() {
//                    @Override
//                    public void onAnimationStart(Animator animation) {
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        imgBackgound1.setVisibility(View.GONE);
//                        Intent intent = new Intent(MainActivity.this, NextActivity.class);
//                        dialog.dismiss();
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                        MainActivity.this.startActivity(intent);
//                        MainActivity.this.overridePendingTransition(R.anim.fade_in, 0);
//                        imgBackgound2.setVisibility(View.VISIBLE);
//                        imgBackgound2.animate().translationX(0);
//                        imgBackgound1.setVisibility(View.VISIBLE);
//                        imgBackgound1.animate().translationX(0);
//                        imgBackgound3.setVisibility(View.VISIBLE);
//                        imgBackgound3.animate().translationY(0);
//                    }
//
//                    @Override
//                    public void onAnimationCancel(Animator animation) {
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animator animation) {
//                    }
//                });
//                fadeOut.setInterpolator(new LinearInterpolator());
//
//                ObjectAnimator fadeOut1 = ObjectAnimator.ofFloat(imgBackgound2, View.TRANSLATION_X,  0, 2 * imgBackgound1.getWidth());
//                fadeOut.addListener(new Animator.AnimatorListener() {
//                    @Override
//                    public void onAnimationStart(Animator animation) {
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        imgBackgound2.setVisibility(View.GONE);
//                    }
//
//                    @Override
//                    public void onAnimationCancel(Animator animation) {
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animator animation) {
//                    }
//                });
//                fadeOut1.setInterpolator(new LinearInterpolator());
//
//                ObjectAnimator fadeOut2 = ObjectAnimator.ofFloat(imgBackgound3, View.TRANSLATION_Y,  0, 2 * imgBackgound3.getHeight());
//                fadeOut.addListener(new Animator.AnimatorListener() {
//                    @Override
//                    public void onAnimationStart(Animator animation) {
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        imgBackgound3.setVisibility(View.GONE);
//
//                    }
//
//                    @Override
//                    public void onAnimationCancel(Animator animation) {
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animator animation) {
//                    }
//                });
//                fadeOut2.setInterpolator(new LinearInterpolator());
//
//                mAnimationSet.playTogether(fadeOut, fadeOut1, fadeOut2);
//                mAnimationSet.setDuration(2000);
//                mAnimationSet.start();
                imgBackgound1.animate().translationX(-5 * imgBackgound1.getWidth()).setDuration(1000).start();
                //imgBackgound1.setVisibility(View.GONE);
                imgBackgound2.animate().translationX(5 * imgBackgound2.getWidth()).setDuration(1000).start();
                //imgBackgound2.setVisibility(View.GONE);
                //imgBackgound3.animate().translationY(-imgBackgound3.getHeight()).setDuration(10).start();
                //imgBackgound3.setVisibility(View.GONE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //MainActivity.this.finish();
                        Intent intent = new Intent(MainActivity.this, NextActivity.class);
                        dialog.dismiss();
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        MainActivity.this.startActivity(intent);
                        MainActivity.this.overridePendingTransition(R.anim.activity_fade_in, R.anim.fade_out);
                        imgBackgound2.setVisibility(View.VISIBLE);
                        imgBackgound2.animate().translationX(0);
                        imgBackgound1.setVisibility(View.VISIBLE);
                        imgBackgound1.animate().translationX(0);
//                        imgBackgound3.setVisibility(View.VISIBLE);
//                        imgBackgound3.animate().translationY(0);
                    }
                }, 500);

            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
