package com.example.user1.baigiamasisapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user1.baigiamasisclient.MainAdapter;

public class RegistracijaActivity extends AppCompatActivity {

    private EditText varvar, sla, var, pav, elp, amz, telnum;
    private Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracija);

        varvar = (EditText) findViewById(R.id.varvar);
        sla = (EditText) findViewById(R.id.sla);
        var = (EditText) findViewById(R.id.var);
        pav = (EditText) findViewById(R.id.pav);
        elp = (EditText) findViewById(R.id.elp);
        amz = (EditText) findViewById(R.id.amž);
        telnum = (EditText) findViewById(R.id.telnum);
        ok = (Button) findViewById(R.id.ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            new registerasync(varvar.getText().toString(), sla.getText().toString(),
                    var.getText().toString(), pav.getText().toString(), elp.getText().toString(),
                    amz.getText().toString(), telnum.getText().toString()).execute();
            }
        });

    }

    public class registerasync extends AsyncTask<String, Void, Void>{
        String varvar;
        String sla;
        String var;
        String pav;
        String elp;
        String amz;
        String telnum;

        public registerasync(String varvar, String sla, String var, String pav, String elp, String amz, String telnum) {
            this.varvar = varvar;
            this.sla = sla;
            this.var = var;
            this.pav = pav;
            this.elp = elp;
            this.amz = amz;
            this.telnum = telnum;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent intent = new Intent(RegistracijaActivity.this, MainActivity.class);
            startActivity(intent);
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(String... params) {
            System.out.println(varvar);

            new MainAdapter(RegistracijaActivity.this).createVartotojas(varvar, sla, var, pav, elp, amz, telnum);
            return null;
        }
    }

}
