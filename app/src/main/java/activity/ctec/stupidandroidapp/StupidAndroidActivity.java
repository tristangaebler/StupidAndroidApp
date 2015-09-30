package activity.ctec.stupidandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.view.View;
import android.graphics.Color;
import android.content.Intent;

public class StupidAndroidActivity extends AppCompatActivity {

    //Declare all the components
    //These are always private
    private Button colorChangeButton;
    private Button swapScreenButton;
    private TextView basicText;
    private RelativeLayout background;

    //Protected means can only be seen inside the package
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stupid_android);

        //Initialized all three data members
        background = (RelativeLayout) findViewById(R.id.BackgroundLayout);
        basicText = (TextView) findViewById(R.id.AwesomeText);
        colorChangeButton = (Button) findViewById(R.id.AwesomeButton);
        swapScreenButton = (Button) findViewById(R.id.swapScreenButton);

        //Helper method - Most of the time private
        setUpListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stupid_android, menu);
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
        int redColor;
        int greenColor;
        int blueColor;

        //Making random colors
        redColor = (int) (Math.random() * 256);
        greenColor = (int) (Math.random() * 256);
        blueColor = (int) (Math.random() * 256);

        background.setBackgroundColor(Color.rgb(redColor, greenColor, blueColor));

        redColor = (int) (Math.random() * 256);
        greenColor = (int) (Math.random() * 256);
        blueColor = (int) (Math.random() * 256);

        colorChangeButton.setBackgroundColor(Color.rgb(redColor, blueColor, blueColor));
    }

    //Changing the visibilty of the text
    private void changeVisibilty() {
        //If test
        if(basicText.getVisibility() == View.VISIBLE) {
            basicText.setVisibility(View.GONE);
        }else {
            basicText.setVisibility(View.VISIBLE);
        }


    }

    private void setUpListeners() {
        colorChangeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View buttonView) {
                //This is where the magic happens
                changeBackgroundColor();
                changeVisibilty();
            }
        });

        swapScreenButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View buttonView) {
                Intent myIntent = new Intent(buttonView.getContext, RunningActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
