package com.util.diablo.utils.anim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.util.diablo.utils.R;

/**
 * Created by Diablo on 2016/12/29.
 * animation动画是同一时间执行的也就是并发执行的，要想控制一组动画的执行顺序就要用到animator,animator可以对一组动画的
 * 执行顺序进行定制。
 */

public class AnimationTest {


    public static Animation getAnimationFromXML(Context context, int res) {
        return AnimationUtils.loadAnimation(context, res);
    }

    public static Animator getAnimatorFromXML(Context context, int res) {
        return AnimatorInflater.loadAnimator(context, res);
    }

    /**
     * 获取透明度动画
     *
     * @param context
     * @return
     */
    public static Animation getAphaAnimation(Context context) {
        Animation apha = getAnimationFromXML(context, R.anim.apha_demo);
        /**
         * fromAlpha
         * Float. 设置透明度的初始值，其中0.0是透明，1.0是不透明的。
         * toAlpha
         * Float. 设置透明度的结束值，其中0.0是透明，1.0是不透明的。
         */
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        return apha;
    }

    /**
     * 获取缩放动画
     *
     * @param context
     * @return
     */
    public static Animation getScaleAnimation(Context context) {
        Animation scale = getAnimationFromXML(context, R.anim.scale_demo);
        /**
         * fromXScale
         * Float. 水平方向缩放比例的初始值，其中1.0是没有任何变化。
         * toXScale
         * Float. 水平方向缩放比例的结束值，其中1.0是没有任何变化。
         * fromYScale
         * Float. 竖直方向缩放比例的初始值，其中1.0是没有任何变化。
         * toYScale
         * Float. 竖直方向缩放比例的结束值，其中1.0是没有任何变化。
         * pivotX
         * Float. 缩放中心点的x坐标
         * pivotY
         * Float. 缩放中心点的y坐标
         */
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        return scale;
    }

    /**
     * 获取缩放动画
     *
     * @param context
     * @return
     */
    public static Animation getTranslateAnimation(Context context) {
        Animation translate = getAnimationFromXML(context, R.anim.translate_demo);
       /*
        * 移动起始点的x坐标. 表示形式有三种：
        * fromXDelta
        * 1 相对于自己的左边界的距离，单位像素值。（例如 "5"）
        * 2 相对于自己的左边界的距离与自身宽度的百分比。（例如  "5%"）
        * 3 相对于父View的左边界的距离与父View宽度的百分比。（例如 "5%p"）
        * toXDelta. 移动结束点的x坐标. 表现形式同上
        * fromYDelta Float or percentage. 移动起始点的y坐标. 表示形式有三种：
        * toYDelta Float or percentage. 移动结束点的y坐标. 表现形式同上
        */
        TranslateAnimation translateAnimation = new TranslateAnimation(1.0f, 100f, 1.0f, 100f);
        translateAnimation.setDuration(300);
        translateAnimation.setInterpolator(new LinearInterpolator());
        return translate;
    }

    /**
     * 获取缩放动画
     *
     * @param context
     * @return
     */
    public static Animation getRotateAnimation(Context context) {
        Animation rotate = getAnimationFromXML(context, R.anim.rotate_demo);
        /**
         * fromDegrees
         * Float. 旋转初始的角度。
         * toDegrees
         * Float. 旋转结束的角度。
         * pivotX
         * Float or percentage. 旋转中心点x坐标，表示形式有三种：
         * 1 相对于自己的左边界的距离，单位像素值。（例如 "5"）
         * 2 相对于自己的左边界的距离与自身宽度的百分比。（例如 "5%"）
         * 3 相对于父View的左边界的距离与父View宽度的百分比。（例如 "5%p"）
         * pivotY
         * Float or percentage. 旋转中心点y坐标，表示形式有三种：
         */
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180f, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(300);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        return rotate;
    }

    public static void showAnimList(ImageView imageView, int animListRes) {
        imageView.setImageResource(animListRes);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();
        //animationDrawable.stop(); //如果oneshot为false，必要时要停止动画
    }


    public static void getAnimator(View view) {
        /**
         * 从0到-100，在到100 translationX translationY
         * translationX 和 translationY：这两个属性控制了View所处的位置，
         * 它们的值是由layout容器设置的，是相对于坐标原点（0，0左上角）的一个偏移量。
         * x 和 y：描述了view在其父容器中的最终位置，是左上角坐标和偏移量（translationX，translationY）的和。
         */
        Animator translationX = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -100.0f, 100.0f);
        translationX.setDuration(4000).start();

        //透明度从1-0-1
        /**
         * aplha：透明度，1是完全不透明，0是完全透明
         */
        Animator alpha = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);
        alpha.setDuration(4000).start();

        //scalX scalY
        /**
         * scaleX 和 scaleY：控制View基于pivotX和pivotY的缩放。
         */
        Animator scalX = ObjectAnimator.ofFloat(view, "scalX", 2.0f, 0.95f);
        scalX.setDuration(4000).start();

        //rotationY  rotationX
        /**
         * rotation, rotationX 和 rotationY：控制View绕着轴点（pivotX和pivotY）旋转。它的表现跟Tween Animation中的RotateAnimation不一致。
         * RotateAnimation 的旋转，表现为平面的旋转
         * 而rotationX、Y 旋转，是立体的旋转，默认是以View的中心点，做rotation(x,y)过中心点的直线，面向该直线进行翻转
         */
        Animator rotation = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
        rotation.setDuration(4000).start();

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translationX, alpha);
        //顺序执行
        //animatorSet.playSequentially(translationX,alpha);
        animatorSet.setDuration(5000);
        animatorSet.start();
    }
}
