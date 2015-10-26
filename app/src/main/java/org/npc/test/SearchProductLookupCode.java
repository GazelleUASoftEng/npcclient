package org.npc.test;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

import org.npc.test.api.enums.ProductApiRequestStatus;
import org.npc.test.api.models.Product;
import org.npc.test.api.services.ProductService;


public class SearchProductLookupCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_lookup_code);
    }

   public void searchProductLookupCodeOnClick(View view){
       Intent intent = new Intent(this, ProductDetails.class);
       EditText lookupcodeSearchBox = (EditText) this.findViewById(R.id.lookupcodeSearchBox);
       String lookupcodeQuery = lookupcodeSearchBox.getText().toString();
       this.startActivity(intent.putExtra(this.getResources().getString(R.string.product_id_extras_key), lookupcodeQuery));
   }
}
