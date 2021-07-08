package sg.edu.rp.c346.id20002369.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;

    @Override
    protected void onResume() {
        super.onResume();

        // S2a: Obtain an instance of SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        // S2b: Retrieve the saved data from the SharedPreferences object
        String getName = prefs.getString("name","No name provided");
        Float getGPA = prefs.getFloat("gpa", 0);
        // S2c: Update the UI element with the value
        etName.setText(getName);
        etGPA.setText(getGPA + "");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // S1a: Get user input from the ET and store it in a variable
        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());
        //S1b: Obtain an instance of SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        // S1c: Obtain instance of SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        //S1d: Add the key-value pair
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        //S1e: Call commit() to save changes into SharedPreference
        prefEdit.commit();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }
}