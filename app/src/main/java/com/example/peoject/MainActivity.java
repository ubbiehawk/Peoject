package com.example.peoject;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    // edit text and text view given
    ImageButton button;
    EditText editText;
    EditText textView;
    
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextMultiLine2);
        button = findViewById(R.id.bt_highlight);
        textView = findViewById(R.id.edit_t);

        button.setOnClickListener(view -> {

                String textToSearch = editText.getText().toString();

                String replace = "<span style = 'background-color:yellow'>" + textToSearch + "</span>";
                String ogText = textView.getText().toString();
                String mdText = ogText.replaceAll(textToSearch, replace);


                textView.setText(Html.fromHtml(mdText));

        });
    }
    public void buttonBold(View view){
        Spannable spannableString = new SpannableStringBuilder(textView.getText());
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), textView.getSelectionStart(),textView.getSelectionEnd(),0);
        textView.setText(spannableString);
    }
    public void buttonItalics(View view){
        Spannable spannableString = new SpannableStringBuilder(textView.getText());
        spannableString.setSpan(new StyleSpan(Typeface.ITALIC),
                textView.getSelectionStart(),
                textView.getSelectionEnd(),
                0);

        textView.setText(spannableString);

    }
    public void buttonUnderline(View view){
        Spannable spannableString = new SpannableStringBuilder(textView.getText());
        spannableString.setSpan(new UnderlineSpan(),
                textView.getSelectionStart(),
               textView.getSelectionEnd(),
                0);

        textView.setText(spannableString);
    }
    public void colorChange(View view){
        SpannableStringBuilder spannable = new SpannableStringBuilder(textView.getText());
        spannable.setSpan(
                new ForegroundColorSpan(Color.BLUE),
                textView.getSelectionStart(), // start
                textView.getSelectionEnd(), // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        );
        textView.setText(spannable);
    }
    public void increase(View view){
        SpannableString string = new SpannableString(textView.getText());
        string.setSpan(new RelativeSizeSpan(1.5f), textView.getSelectionStart(), textView.getSelectionEnd(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(string);
    }
    public void decrease(View view){
        SpannableString string = new SpannableString(textView.getText());
        string.setSpan(new RelativeSizeSpan(.8f), textView.getSelectionStart(), textView.getSelectionEnd(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(string);
    }
}