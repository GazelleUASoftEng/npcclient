package org.npc.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import org.npc.test.objects.TransactionObject;
import org.npc.test.objects.orderObject;

public class transaction extends AppCompatActivity {
    TransactionObject transObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        transObj = new TransactionObject();
        orderObject order = new orderObject();

        TextView trans = (TextView)findViewById(R.id.transaction_total);
        trans.setText("Transaction total is :   " + transObj.getTrans_total());

        TextView pay = (TextView)findViewById(R.id.payment_total);
        pay.setText("Payement total is :    " + transObj.getPay_total());

        TextView balance = (TextView)findViewById(R.id.balance_left);
        balance.setText("Remaining Balance is :     " + transObj.getBalance());

        Button searchProduct = (Button)findViewById(R.id.product_button);
        searchProduct.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent("org.npc.test.SearchProductLookupCode");
                intent.putExtra("TransactionObject",transObj);
                startActivity(intent);
            }
        });
        Button next = (Button)findViewById(R.id.complete_transaction);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }

        });
    }
    protected void onResume(){
        super.onResume();
        Intent i = getIntent();
        transObj = (TransactionObject)i.getSerializableExtra("TransactionObject");
       // setTransaction(transObj);
    }

    private void setTransaction(TransactionObject to){
        TextView trans = (TextView)findViewById(R.id.transaction_total);
        trans.setText("Transaction total is :   " + to.getTrans_total());
    }

    /**
     * Created by Calvin on 11/15/15.
     */

}
