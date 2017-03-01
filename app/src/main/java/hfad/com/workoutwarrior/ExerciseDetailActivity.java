package hfad.com.workoutwarrior;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExerciseDetailActivity extends AppCompatActivity {

    private EditText editText_name;
    private EditText editText_weight;
    private EditText editText_reps;
    private EditText editText_date;
    private Button button_save;
    private Button button_update;

    private Exercise exercise;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);

        editText_name = (EditText) findViewById(R.id.editText_name);
        editText_weight = (EditText) findViewById(R.id.editText_weight);
        editText_reps = (EditText) findViewById(R.id.editText_reps);
        editText_date = (EditText) findViewById(R.id.editText_date);
        button_save = (Button) findViewById(R.id.button_save);
        button_update = (Button) findViewById(R.id.button_update);



        Bundle b2 = getIntent().getExtras();
        if(b2!=null){
            int position = b2.getInt("positon");
            DBHelper db = new DBHelper(this);
            exercise = db.getAllExercises().get(position);
            editText_weight.setText(exercise.getWeight());
            editText_reps.setText(exercise.getReps());
            editText_date.setText(exercise.getDate());
            button_save.setVisibility(View.INVISIBLE);
        }


        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                saveExercise();
            }
        });
        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                updateExercise();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.details_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.menu_delete_exercise:

                deleteExercise();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void saveExercise() {

        DBHelper db = new DBHelper(this);
        Exercise newExercise = new Exercise();
        newExercise.setName(editText_name.getText().toString());
        newExercise.setWeight(editText_weight.getText().toString());
        newExercise.setReps(editText_reps.getText().toString());
        newExercise.setDate(editText_date.getText().toString());

        db.insertExercise(newExercise);
        finish();
    }
    private void updateExercise() {

        DBHelper db = new DBHelper(this);
        Exercise newExercise = new Exercise();
        newExercise.setId(exercise.getId());
        newExercise.setName(editText_name.getText().toString());
        newExercise.setWeight(editText_weight.getText().toString());
        newExercise.setReps(editText_reps.getText().toString());
        newExercise.setDate(editText_date.getText().toString());

        db.updateExercise(newExercise);
        finish();
    }
    private void deleteExercise() {

        DBHelper db = new DBHelper(this);

        db.deleteExercise(exercise);
        finish();
    }
}
