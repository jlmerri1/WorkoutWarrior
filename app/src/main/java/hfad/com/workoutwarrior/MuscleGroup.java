package hfad.com.workoutwarrior;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MuscleGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_group);
    }
    public void nextPage(View view)
    {
        Intent intent = new Intent(MuscleGroup.this, chest.class);
        startActivity(intent);
    }
    public void toBackExercises(View view)
    {
        Intent intent = new Intent(MuscleGroup.this, back.class);
        startActivity(intent);
    }
    public void toArmExercises(View view)
    {
        Intent intent = new Intent(MuscleGroup.this, arms.class);
        startActivity(intent);
    }
    public void toCoreExercises(View view)
    {
        Intent intent = new Intent(MuscleGroup.this, core.class);
        startActivity(intent);
    }
    public void toLegExercises(View view)
    {
        Intent intent = new Intent(MuscleGroup.this, legs.class);
        startActivity(intent);
    }
    public void toCardioExercises(View view) {
        Intent intent = new Intent(MuscleGroup.this, cardio.class);
        startActivity(intent);
    }
}
