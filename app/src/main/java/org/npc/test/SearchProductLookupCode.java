package org.npc.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

import org.npc.test.objects.TransactionObject;
import org.npc.test.objects.orderObject;

import java.util.ArrayList;


public class SearchProductLookupCode extends AppCompatActivity {
    public static String lookupcodeQuery;
    ArrayList<orderObject> list = new ArrayList<orderObject>();
    TransactionObject obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        orderObject foo = new orderObject(0, "foo", "bar", 1.0);
        list.add(foo);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_lookup_code);
        Intent i = getIntent();
        ListView Orders = (ListView)findViewById(R.id.OrderList);
        ArrayAdapter<orderObject> arrayAdapter = new ArrayAdapter<orderObject>(
                this,android.R.layout.simple_list_item_1 ,
                list );
        Orders.setAdapter(arrayAdapter);

        TransactionObject obj = (TransactionObject)i.getSerializableExtra("TransactionObject");
    }
    protected void onResume(){

        super.onResume();
        Intent i = getIntent();
        obj = (TransactionObject)i.getSerializableExtra("TransactionObject");

    }
    protected void onPause(){
        super.onPause();
       /* obj.setBalance(20);
        Intent i = new Intent("org.npc.transaction");
        i.putExtra("TransactionObject", obj);
        startActivity(i);
*/
    }
   public void searchProductLookupCodeOnClick(View view){
       Intent intent = new Intent(this, ProductDetails.class);
       EditText lookupcodeSearchBox = (EditText) this.findViewById(R.id.lookupcodeSearchBox);
       lookupcodeQuery = lookupcodeSearchBox.getText().toString();
       this.startActivity(intent.putExtra(this.getResources().getString(R.string.product_id_extras_key), lookupcodeQuery));
   }
}
