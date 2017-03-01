package hfad.com.workoutwarrior;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class LandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
    }
    public void nextPage(View view)
    {
        Intent intent = new Intent(LandingPage.this, MuscleGroup.class);
        startActivity(intent);
    }
}
