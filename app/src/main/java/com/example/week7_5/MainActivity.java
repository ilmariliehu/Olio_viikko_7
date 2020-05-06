package com.example.week7_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Context context = null;

    EditText textInput2;
    EditText textInput;
    String file = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        textInput = (EditText) findViewById(R.id.editText);
        textInput2 = (EditText) findViewById(R.id.editText2);


    }

    public void readFile(View v){
        file = textInput2.getText().toString();
        try{
            InputStream is = context.openFileInput(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String s = "";
            while((s = br.readLine()) != null){
                textInput.setText(s);
            }
            is.close();

        }catch(IOException e){
            Log.e("IOException", "Virhe");
        }finally{
            System.out.println("Luettu");
        }
        System.out.println("Tiedoston sijainti " +context.getFilesDir());

    }
    public void writeFile(View v){
        file = textInput2.getText().toString();
        try{
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput(file, Context.MODE_PRIVATE));
            String i = textInput.getText().toString();
         /*   while(i == null) {
                ows.write(i);
            }*/
            ows.write(i);

            ows.close();
        }catch(IOException e){
            Log.e("IOException", "Virhe");
        }finally{
            System.out.println("Kirjoitettu");
        }
    }
}

