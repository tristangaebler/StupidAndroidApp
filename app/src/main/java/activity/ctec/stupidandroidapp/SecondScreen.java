package activity.ctec.stupidandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.content.Intent;
import android.graphics.Color;

public class SecondScreen extends AppCompatActivity {

    private Button homeButton;
    private Button colorChange;

    private RelativeLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        homeButton = (Button) findViewById(R.id.returnHomeButton);
        colorChange = (Button) findViewById(R.id.changeColors);

        background = (RelativeLayout) findViewById(R.id.secondBackground);
        setUpListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void changeBackgroundColor() {
        int red;
        int blue;
        int green;

        //Generate random colors
        red = (int) (Math.random() * 256);
        blue = (int) (Math.random() * 256);
        green = (int) (Math.random() * 256);

        background.setBackgroundColor(Color.rgb(red, green, blue));
    }

    private void setUpListeners() {

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View buttonView) {
                Intent returnIntent = new Intent();
                setResult(RESULT_OK, returnIntent);
                //Turns of activity
                changeBackgroundColor();
                finish();
            }
        });
    }
}

















