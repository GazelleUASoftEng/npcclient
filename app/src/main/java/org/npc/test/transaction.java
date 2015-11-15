package org.npc.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import org.npc.test.TransactionObject;
import org.w3c.dom.Text;

import android.widget.Button;
import android.widget.TextView;

public class transaction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TransactionObject transObj = new TransactionObject();
        TextView trans = (TextView)findViewById(R.id.transaction_total);
        trans.setText("Transaction total is :   " + transObj.getTrans_total());
        TextView pay = (TextView)findViewById(R.id.payment_total);
        pay.setText("Payement total is :    " + transObj.getPay_total());
        TextView balance = (TextView)findViewById(R.id.balance_left);
        balance.setText("Remaining Balance is :     " + transObj.getBalance());
        Button next = (Button)findViewById(R.id.complete_transaction);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }

        });
    }

}
