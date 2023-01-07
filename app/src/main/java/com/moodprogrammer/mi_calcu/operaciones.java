package com.moodprogrammer.mi_calcu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class operaciones extends AppCompatActivity {

    Button btn0, btndobleCero, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPorcent, btnPlus, btnMinus, btnMulti, btnDivision, btnIguall, btnLimpiado, btnDot, btnBracket;
    TextView input, output;
    String proceso;
    boolean checkBracket = false;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        btn0 = findViewById(R.id.btnCero);
        btndobleCero = findViewById(R.id.btndobleCero);
        btn1 = findViewById(R.id.btnUno);
        btn2 = findViewById(R.id.btnDos);
        btn3 = findViewById(R.id.btntres);
        btn4 = findViewById(R.id.btnCuatro);
        btn5 = findViewById(R.id.btnCinco);
        btn6 = findViewById(R.id.btnSeis);
        btn7 = findViewById(R.id.btnSiete);
        btn8 = findViewById(R.id.btnOcho);
        btn9 = findViewById(R.id.btnNueve);

        btnPlus = findViewById(R.id.btnSuma);
        btnPorcent = findViewById(R.id.btnPorcentaje);
        btnMinus = findViewById(R.id.btnResta);
        btnMulti = findViewById(R.id.btnMultiplicar);
        btnDivision = findViewById(R.id.btnDivision);
        btnIguall = findViewById(R.id.btnIgual);
        btnLimpiado = findViewById(R.id.btnLimpiar);
        btnDot = findViewById(R.id.btnPunto);
        btnBracket = findViewById(R.id.btnParentesis);



        input = findViewById(R.id.input);
        output = findViewById(R.id.output);



        btnLimpiado.setOnClickListener(v -> {
            input.setText("");
            output.setText("");


        });

        btn0.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "0");
        });

        btndobleCero.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "00");
        });

        btn1.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "1");
        });

        btn2.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "2");
        });

        btn3.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "3");
        });

        btn4.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "4");
        });

        btn5.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "5");
        });

        btn6.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "6");
        });

        btn7.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "7");
        });

        btn8.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "8");
        });

        btn9.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "9");
        });

        btnPlus.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "+");
        });

        btnMinus.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "-");
        });

        btnMulti.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "×");
        });

        btnDivision.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "÷");
        });

        btnDot.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + ".");
        });

        btnPorcent.setOnClickListener(v -> {
            proceso = input.getText().toString();
            input.setText(proceso + "%");
        });

        btnBracket.setOnClickListener(v -> {
            if(checkBracket) {
                proceso = input.getText().toString();
                input.setText(proceso + ")");
                checkBracket = false;
            }else{
                proceso = input.getText().toString();
                input.setText(proceso + "(");
                checkBracket = true;
            }
        });

        btnIguall.setOnClickListener(v -> {
            proceso = input.getText().toString();

            proceso = proceso.replaceAll("×", "*");
            proceso = proceso.replaceAll("%", "/100");
            proceso = proceso.replaceAll("÷", "/");

            Context rhino = Context.enter();
            rhino.setOptimizationLevel(-1);





            String finalResult = "";


            try{
                Scriptable scriptable = rhino.initSafeStandardObjects();
                finalResult = rhino.evaluateString(scriptable, proceso, "javascript", 1, null).toString();

            } catch (Exception e){
                finalResult = "0";
            }

            output.setText(finalResult);


        });

        }
}