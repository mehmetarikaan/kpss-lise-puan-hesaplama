package com.arsey.kpssortaogretimpuanhesaplama;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Puan extends AppCompatActivity {



    Button tekrarHesapla;

    TextView sayisals,matnet,turknet;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puan);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        getSupportActionBar().setTitle("Puan Hesaplama");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sayisals = findViewById(R.id.sayisals);
        matnet = findViewById(R.id.matnet);
        turknet = findViewById(R.id.turknet);
        tekrarHesapla = findViewById(R.id.tekrarHesapla);



        double turkdogru = getIntent().getDoubleExtra("td",1);
        double turkyanlis = getIntent().getDoubleExtra("ty",1);
        double matdogru= getIntent().getDoubleExtra("md",1);
        double matyanlis = getIntent().getDoubleExtra("my",1);



        double turkcenet = turkdogru-(turkyanlis/4);
        double matematiknet = matdogru-(matyanlis/4);
        double sayisalpuan = 0.5*(matematiknet+turkcenet)+(40);



        turknet.setText(""+turkcenet);
        matnet.setText(""+matematiknet);
        sayisals.setText(""+sayisalpuan);



    }

    public void tekrarHesapla(View view) {
        Intent intent = new Intent(Puan.this,MainActivity.class);
        startActivity(intent);


    }
}
