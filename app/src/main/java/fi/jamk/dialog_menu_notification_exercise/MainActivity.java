package fi.jamk.dialog_menu_notification_exercise;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_sendFeedback:
                SendFeedback();
                return true;
            case R.id.action_quit:
                Quit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

    private void SendFeedback(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, new String [] {"jerevaltanen@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback on Week 37 exercise");
        intent.putExtra(Intent.EXTRA_TEXT, "Enter feedback here");

        startActivity(Intent.createChooser(intent, "Send Feedback Email"));
    }

    private void Quit(){
        QuitDialogFragment quitDialogFragment = new QuitDialogFragment();
        quitDialogFragment.show(getFragmentManager(), "quit");
    }
}
