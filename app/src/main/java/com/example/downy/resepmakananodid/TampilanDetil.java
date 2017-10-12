package com.example.downy.resepmakananodid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class TampilanDetil extends AppCompatActivity {

    ImageView gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_detil);
        Bundle b = getIntent().getExtras();
        gambar=(ImageView)findViewById(R.id.gambar);
        gambar.setImageResource(b.getInt("gambar"));
        setTitle(b.getString("label"));
    }
}
