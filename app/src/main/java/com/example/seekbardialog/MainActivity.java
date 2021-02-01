package com.example.seekbardialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener , SeekBar.OnSeekBarChangeListener {
    Button button;
    TextView textView;
    SeekBar seekBar;
    int value = 0;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        launchDialog();
    }

    void launchDialog(){
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.dialog, (ViewGroup) findViewById(R.id.layout));

        seekBar = layout.findViewById(R.id.seekBar);
        seekBar.setProgress(progress);
        seekBar.setOnSeekBarChangeListener(this);

        new AlertDialog.Builder(this)
                .setTitle("title")
                .setMessage("message")
                .setView(layout)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // OK button pressed
                        textView.setText("OK:"+value);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // OK button pressed
                        textView.setText("Cancel");
                    }
                })
                .show();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        value = i*50 + 200;
        progress = i;
        Log.d("TAG", "onProgressChanged: "+ i);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}