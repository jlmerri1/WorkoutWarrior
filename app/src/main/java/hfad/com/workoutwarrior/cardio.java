package hfad.com.workoutwarrior;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class cardio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);
    }
    public void backToMuscleGroups(View view)
    {
        Intent intent = new Intent(this, MuscleGroup.class);
        startActivity(intent);
    }

}
