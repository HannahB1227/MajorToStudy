package edu.uga.cs.majortostudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.InputStream;

/*
    This class supports the Description Activity and implements the filling of the TextView and
    ImageView.
 */
public class DescriptionActivity extends AppCompatActivity {

    TextView text;
    ImageView image;
    private int MajorCode;

    @Override
    /*
        This method indicates what should be done when the Activity is created including choosing
        which text file and image are inputted into the views.
        @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        //Set up TextView and ImageView
        text = findViewById(R.id.textView3);
        image = findViewById(R.id.imageView);

        //Input information based upon data from parent activity
        Intent intent = getIntent();
        MajorCode = intent.getIntExtra(MainActivity.MSG, MainActivity.MajorCode);
        if (MajorCode == 1) {
            try {
                Resources res = getResources();
                InputStream in = res.openRawResource(R.raw.cs_description_text);
                byte[] b = new byte[in.available()];
                in.read(b);
                text.setText(new String(b));
                image.setImageDrawable(res.getDrawable(R.drawable.computer_science));
            } catch (Exception e) {
                text.setText("Error: Unable to find information!");
            } //try-catch
        } //if
        else if (MajorCode == 2) {
            try {
                Resources res = getResources();
                InputStream in = res.openRawResource(R.raw.biology_description_text);
                byte[] b = new byte[in.available()];
                in.read(b);
                text.setText(new String(b));
                image.setImageDrawable(res.getDrawable(R.drawable.biology));
            } catch (Exception e) {
                text.setText("Error: Unable to find information!");
            } //try-catch
        } //else-if
        else if (MajorCode == 3) {
            try {
                Resources res = getResources();
                InputStream in = res.openRawResource(R.raw.psychology_description_text);
                byte[] b = new byte[in.available()];
                in.read(b);
                text.setText(new String(b));
                image.setImageDrawable(res.getDrawable(R.drawable.psychology));
            } catch (Exception e) {
                text.setText("Error: Unable to find information!");
            } //try-catch
        } //else-if
        else if (MajorCode == 4) {
            try {
                Resources res = getResources();
                InputStream in = res.openRawResource(R.raw.economics_description_text);
                byte[] b = new byte[in.available()];
                in.read(b);
                text.setText(new String(b));
                image.setImageDrawable(res.getDrawable(R.drawable.economics));
            } catch (Exception e) {
                text.setText("Error: Unable to find information!");
            } //try-catch
        } //else-if
        else if (MajorCode == 5) {
            try {
                Resources res = getResources();
                InputStream in = res.openRawResource(R.raw.journalism_description_text);
                byte[] b = new byte[in.available()];
                in.read(b);
                text.setText(new String(b));
                image.setImageDrawable(res.getDrawable(R.drawable.journalism));
            } catch (Exception e) {
                text.setText("Error: Unable to find information!");
            } //try-catch
        } //else-if
    } //ocCreate
} //DescriptionActivity
