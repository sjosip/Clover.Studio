package com.example.josip.cloverstudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber;
    private Button bPopni;
    private Button bIspis;
    private TextView tvManji, tvVeci;
    int broj, mbroj, vbroj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNumber = (EditText)findViewById(R.id.etNumber);
        bIspis = (Button)findViewById(R.id.bIspis);
        tvManji = (TextView)findViewById(R.id.tvManji);
        tvVeci = (TextView)findViewById(R.id.tvVeci);


        bIspis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broj = Integer.parseInt(etNumber.getText().toString());
                mbroj = nadjiManji(broj);
                tvManji.setText("Manji od zadanog je : " + mbroj);
                vbroj = nadjiVeci(broj);
                tvVeci.setText("Veći od zadanog je : " + vbroj);
                if (tvManji.getText().toString().equals("0")) {
                    tvManji.setText("Nema manji broj");
                } if (tvVeci.getText().toString().equals("0")) {
                    tvVeci.setText("Nema veceg broja");
                }

            }
        });

    }

    private int nadjiVeci(int broj) {
        int broj2=0;
        boolean pronadjen = false;

        for (int i=broj+1; pronadjen==false; i++){
            char[] chars1 = String.valueOf(broj).toCharArray();
            char[] chars2 = String.valueOf(i).toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);
            if (Arrays.equals(chars1, chars2)){
                pronadjen=true;
                broj2 = i;
                break;
            }

            if (i>=10000){
                tvVeci.setText("Nema većeg broja!");
                break;
            }


        }
        return broj2;


    }

    private int nadjiManji(int broj) {
        int broj2=0;
        boolean pronadjen = false;

        for (int i=broj-1; pronadjen==false; i--){
            char[] chars1 = String.valueOf(broj).toCharArray();
            char[] chars2 = String.valueOf(i).toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);
            if (Arrays.equals(chars1, chars2)){
                pronadjen=true;
                broj2 = i;
                break;
            }

            if (i<=0){
                tvManji.setText("Nema manjeg broja!");
                break;
            }


        }
        return broj2;


    }




}




