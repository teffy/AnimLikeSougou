
package com.teffy.app.anim.likesougou;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View v = inflater.inflate(R.layout.dialog, null);
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setPositiveButton("OK", new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setView(v).create();
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        LayoutParams attributes = window.getAttributes();
        Display display = dialog.getWindow().getWindowManager().getDefaultDisplay();
        attributes.width = display.getWidth();
        attributes.height = -1;
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.DialogAnimation);
        return dialog;
    }
    
    
    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if(dismissListener != null){
            dismissListener.onDismiss(dialog);
        }
    }
    
    
    private OnDismissListener dismissListener;
    public void setDismssListener(OnDismissListener dismissListener){
        this.dismissListener = dismissListener;
    }
}
