package edu.uga.cs.majortostudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

/*
    This class supports the Main Activity of the application and implements the spinner and button functions.
 */
public class MainActivity extends AppCompatActivity {

    Button description, employment;
    Spinner spinner;

    public static int MajorCode = 1;
    public static String MSG = "edu.uga.cs.majortostudy.MajorCode";

    @Override
    /*
        This method indicates what should be done when the Activity is created including setting
        up the spinner and buttons along with their respective listeners.
        @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up the two buttons and add a new listener
        description = findViewById(R.id.button);
        employment = findViewById(R.id.button2);
        ButtonClickListener b = new ButtonClickListener();
        description.setOnClickListener(b);
        employment.setOnClickListener(b);

        //Set up spinner and add a new listener
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            /*
                This method indicates what should be done when the user selects an option in the
                spinner
                @param parent
                @param view
                @param pos
                @param id
             */
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if (parent.getItemAtPosition(pos).equals("Computer Science")) {
                    MajorCode = 1;
                } //if
                else if (parent.getItemAtPosition(pos).equals("Biology")) {
                    MajorCode = 2;
                } //else-if
                else if (parent.getItemAtPosition(pos).equals("Psychology")) {
                    MajorCode = 3;
                } //else-if
                else if (parent.getItemAtPosition(pos).equals("Economics")) {
                    MajorCode = 4;
                } //else-if
                else if (parent.getItemAtPosition(pos).equals("Journalism")) {
                    MajorCode = 5;
                } //else-if
            } //onItemSelected

            @Override
            /*
                This method indicates what should happen when nothing is selected in the spinner
                @param parent
             */
            public void onNothingSelected(AdapterView<?> parent) {
            } //onNothingSelected
        });

    } //onCreate

    /*
        This class supports the buttons and performs some action after the user clicks one of them.
     */
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        /*
            This method indicates what action should be taken based upon which button was clicked
            @param view
         */
        public void onClick(View view) {
            if (view.getId() == R.id.button) {
                Intent intent = new Intent(view.getContext(), DescriptionActivity.class);
                intent.putExtra(MSG, MajorCode);
                view.getContext().startActivity(intent);
            } //if
            else {
                Intent intent = new Intent(view.getContext(), EmploymentActivity.class);
                intent.putExtra(MSG, MajorCode);
                view.getContext().startActivity(intent);
            } //else
        } //onClick

    } //ButtonClickListener
}
