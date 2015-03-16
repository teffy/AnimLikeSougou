
package com.teffy.app.anim.likesougou;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getView().findViewById(R.id.show).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    OnDismissListener dismissListener = new OnDismissListener() {
        @Override
        public void onDismiss(DialogInterface dialog) {
            hideAnimator();
        }
    };
    @SuppressWarnings("deprecation")
    protected void showDialog() {
        MDialogFragment dialogFragment = new MDialogFragment();
        dialogFragment.setDismssListener(dismissListener);
        dialogFragment.show(getFragmentManager(), "DIALOG");
        
        long duration = 500;
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        FrameLayout frameLayout = (FrameLayout) getActivity().findViewById(R.id.root_content);
        float[] scale = new float[2];
        scale[0] = 1.0f;
        scale[1] = 0.8f;
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(frameLayout, "scaleX", scale).setDuration(duration);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(frameLayout, "scaleY", scale).setDuration(duration);
        float[] rotation = new float[]{0,10,0};
        ObjectAnimator rotationX = ObjectAnimator.ofFloat(frameLayout, "rotationX", rotation).setDuration(duration);
        
        float[] translation = new float[1];
        translation[0] = -display.getWidth() * 0.2f / 2;
        ObjectAnimator translationY = ObjectAnimator.ofFloat(frameLayout, "translationY",translation).setDuration(duration);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleX,scaleY,rotationX,translationY);
        animatorSet.setTarget(frameLayout);
        animatorSet.start();
    }

    protected void hideAnimator() {
        long duration = 500;
        FrameLayout frameLayout = (FrameLayout) getActivity().findViewById(R.id.root_content);
        float[] scale = new float[2];
        scale[0] = 0.8f;
        scale[1] = 1.0f;
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(frameLayout, "scaleX", scale).setDuration(duration);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(frameLayout, "scaleY", scale).setDuration(duration);
        float[] rotation = new float[]{0,10,0};
        ObjectAnimator rotationX = ObjectAnimator.ofFloat(frameLayout, "rotationX", rotation).setDuration(duration);
        
        float[] translation = new float[1];
        translation[0] = 0;
        ObjectAnimator translationY = ObjectAnimator.ofFloat(frameLayout, "translationY",translation).setDuration(duration);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleX,scaleY,rotationX,translationY);
        animatorSet.setTarget(frameLayout);
        animatorSet.start();        
    }
}
