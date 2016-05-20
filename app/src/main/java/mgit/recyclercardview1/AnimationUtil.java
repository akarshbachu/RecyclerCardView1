package mgit.recyclercardview1;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by bachu_000 on 24-03-2016.
 */
public class AnimationUtil {
    public static void animate(RecyclerView.ViewHolder holder,boolean goesDown){
        AnimatorSet animatorSet=new AnimatorSet();
        //animation in y-axis
        ObjectAnimator animatorTranslateY=ObjectAnimator.ofFloat(holder.itemView,"TranslateY",goesDown==true?200:-200,0);// last param indiccates it will animate from +ve or -ve x-axis to its original position
        animatorTranslateY.setDuration(1000);
        //animation for x-axis
        ObjectAnimator animatorTranslateX=ObjectAnimator.ofFloat(holder.itemView,"TranslateX",-50,50,-30,30,-20,20,-5,5,0);
        animatorTranslateY.setDuration(1000);

        animatorSet.playTogether(animatorTranslateX,animatorTranslateY);//animations of x and y axis or multiple animations are passed to animatiorSet to play at a time
        animatorSet.start();

    }
}
