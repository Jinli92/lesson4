package com.example.jinliyu.codingchallenges6;

import android.content.SharedPreferences;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.EditorInfo;

public class MainActivity extends AppCompatActivity {

    EditText name;
    private final String TAG= MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextName);
        if(name != null){
            name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean mHandled = false;
                    if (actionId == EditorInfo.IME_ACTION_SEND) {
                        dialNumber();
                        mHandled = true;
                    }
                    return mHandled;
                }
            });
        }

    }

    private void dialNumber() {

        EditText editText = (EditText) findViewById(R.id.editTextName);
        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle("Select an application:")
                .setText(editText.getText().toString())
                .startChooser();

    }
}
