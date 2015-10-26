package org.npc.test;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.Intent;

import org.npc.test.api.enums.ProductApiRequestStatus;
import org.npc.test.api.models.Product;
import org.npc.test.api.services.ProductService;

import java.util.UUID;

public class ProductDetails extends AppCompatActivity {
    public String productLookupCode = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent intent = getIntent();
        productLookupCode = intent.getStringExtra(this.getResources().getString(R.string.product_id_extras_key));

    }

    @Override
    protected void onResume() {
        super.onResume();

        (new RetrieveProductTask()).execute(this.productLookupCode);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private TextView getLookupCodeTextView() {
        return (TextView) this.findViewById(R.id.lookupcodeSearchBox);
    }

    private TextView getDescriptionTextView(){
        return (TextView) this.findViewById(R.id.productDescriptionResults);
    }

    private TextView getPriceTextView(){
        return (TextView) this.findViewById(R.id.productPriceResults);
    }

    private TextView getQuantityTextView(){
        return (TextView) this.findViewById(R.id.productQuantityResults);
    }


    private class RetrieveProductTask extends AsyncTask<String, Void, Product> {
        protected Product doInBackground(String... productLookupCodes) {
            return (new ProductService()).getProductByLookupCode(productLookupCodes[0]);
        }

        protected void onPostExecute(Product result) {
            if (result.getApiRequestStatus() == ProductApiRequestStatus.OK) {
                getLookupCodeTextView().setText(result.getLookupCode());

                //The following 3 methods need to be implemented
                getDescriptionTextView().setText(result.getProductDescription());
                getPriceTextView().setText(result.getProductPrice());
                getQuantityTextView().setText(result.getProductQuantity());
            } else {
                getLookupCodeTextView().setText(result.getApiRequestStatus().name());
            }
        }
    }
}
