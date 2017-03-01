package hfad.com.workoutwarrior;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class arms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arms);
    }
    public void backToMuscleGroups(View view)
    {
        Intent intent = new Intent(arms.this, MuscleGroup.class);
        startActivity(intent);
    }
    public void toExerciseList(View view)
    {
        Intent intent = new Intent(arms.this, exercise_list.class);
        startActivity(intent);
    }
}
