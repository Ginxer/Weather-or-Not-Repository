package com.shellhacks.josephkocis.weatherornot;

import android.support.v4.app.DialogFragment;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.content.Context;
// Test test this is George Testing Github
public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        int github =0;
        github++;
        
        builder.setTitle("Yikes, sorry")
                .setMessage("There was an error")
                .setPositiveButton("okie", null);

        return builder.create();
    }
}

