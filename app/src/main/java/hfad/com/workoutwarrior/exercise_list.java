package hfad.com.workoutwarrior;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class exercise_list extends AppCompatActivity {

    private ListView listView_allExercises;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        listView_allExercises = (ListView) findViewById(R.id.listView_allExercises);
        listView_allExercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(exercise_list.this, ExerciseDetailActivity.class);
                Bundle b = new Bundle();
                b.putInt("position", position);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.main_new_exercise:
                startActivity(new Intent(exercise_list.this, ExerciseDetailActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume(){


        DBHelper db = new DBHelper(this);
        ArrayList<String> names = new ArrayList<String>();

        for (int i = 0; i < db.getAllExercises().size(); i++)
            names.add(db.getAllExercises().get(i).getName());


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);
        listView_allExercises.setAdapter(adapter);
        super.onResume();
    }
}
