package hfad.com.workoutwarrior;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class chest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);
    }
    public void backToMuscleGroups(View view)
    {
        Intent intent = new Intent(chest.this, MuscleGroup.class);
        startActivity(intent);
    }
    public void toBenchPressInput(View view)
    {
        Intent intent = new Intent(chest.this, barbellBenchPress.class);
        startActivity(intent);
    }
    public void toChestFlyeInput(View view)
    {
        Intent intent = new Intent(chest.this, machineChestFlye.class);
        startActivity(intent);
    }

    public void toDeclineBenchPress(View view)
    {
        Intent intent = new Intent(chest.this, declineBenchPress.class);
        startActivity(intent);
    }
    public void toDumbbellFlye(View view)
    {
        Intent intent = new Intent(chest.this, dumbbellFlye.class);
        startActivity(intent);
    }
    public void toPushUp(View view)
    {
        Intent intent = new Intent(chest.this, pushup.class);
        startActivity(intent);
    }
    public void toInclineBarbellBenchPress(View view)
    {
        Intent intent = new Intent(chest.this, inclineBarbellBenchPress.class);
        startActivity(intent);
    }
}
