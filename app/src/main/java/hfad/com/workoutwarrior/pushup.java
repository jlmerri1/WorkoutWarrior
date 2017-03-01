package hfad.com.workoutwarrior;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;
import android.widget.EditText;


public class pushup extends AppCompatActivity {


    private EditText weightInput;
    private EditText repInput;
    private Button submitInfo;

    private int seconds = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pushup);

        weightInput = (EditText) findViewById(R.id.weightInput);
        repInput = (EditText) findViewById(R.id.repInput);
        submitInfo = (Button) findViewById(R.id.sumbitInfo);

        submitInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                saveExercise();
            }
        });
        if (savedInstanceState != null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        runTimer();
    }

    public void toExerciseList(View view)
    {

    }
    private void saveExercise() {

        DBHelper db = new DBHelper(this);
        Exercise newExercise = new Exercise();
        newExercise.setName(weightInput.getText().toString());
        newExercise.setWeight(repInput.getText().toString());
        db.insertExercise(newExercise);
        finish();
        Intent intent = new Intent(pushup.this, exercise_list.class);
        startActivity(intent);
    }
    public void backToMuscleGroups(View view)
    {
        Intent intent = new Intent(pushup.this, MuscleGroup.class);
        startActivity(intent);
    }
    public void backToChest(View view)
    {
        Intent intent = new Intent(pushup.this, chest.class);
        startActivity(intent);
    }
    public void onClickRestThirty(View view)
    {
        running = true;
        seconds = 30;
    }
    public void onClickRestSixty(View view)
    {
        running = true;
        seconds = 60;
    }
    public void onClickRestNinety(View view)
    {
        running = true;
        seconds = 90;
    }
    public void onClickRestOneTwenty(View view)
    {
        running = true;
        seconds = 120;
    }

    private void runTimer(){
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%02d:%02d", minutes, secs);
                timeView.setText(time);
                if (running && seconds >0)
                {
                    seconds--;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
    }



}
