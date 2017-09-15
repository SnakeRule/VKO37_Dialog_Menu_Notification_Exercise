package fi.jamk.dialog_menu_notification_exercise;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Jere on 14.9.2017.
 */

public class AddReminderDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.add_reminder_dialog, null);

        builder.setView(dialogView)
                .setTitle(R.string.remDialogTitle)

                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        EditText delayText = (EditText) dialogView.findViewById(R.id.remWhenEditText);
                        long delay = (long) Double.parseDouble(delayText.getText().toString());

                        EditText contentEditText = (EditText) dialogView.findViewById(R.id.RemContentEditText);
                        String message = contentEditText.getText().toString();

                        AddReminder addReminder = new AddReminder(getActivity().getApplicationContext(), delay, 1, message);
                    }
                })


                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
