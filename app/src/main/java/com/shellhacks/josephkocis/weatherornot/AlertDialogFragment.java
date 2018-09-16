package com.shellhacks.josephkocis.weatherornot;

import android.support.v4.app.DialogFragment;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.content.Context;

public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("Oops, sorry")
                .setMessage("There was an error")
                .setPositiveButton("OK", null);

        return builder.create();
    }
}

