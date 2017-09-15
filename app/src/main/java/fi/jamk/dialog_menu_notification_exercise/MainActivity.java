package fi.jamk.dialog_menu_notification_exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void addRemClicked(View view){
        AddReminderDialogFragment reminderDialogFragment = new AddReminderDialogFragment();
        reminderDialogFragment.show(getFragmentManager(), "addRem");
    }

    public void imageToastClicked(View view)
    {
        LayoutInflater inflater = getLayoutInflater();

        View view1 = inflater.inflate(R.layout.custom_image_toast, (ViewGroup) findViewById(R.id.relativeLayout1));

        Toast toast = new Toast(this);
        toast.setView(view1);
        toast.show();
    }
}
