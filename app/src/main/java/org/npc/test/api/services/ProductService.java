package org.npc.test.api.services;

import org.json.JSONObject;
import org.npc.test.api.enums.ApiLevel;
import org.npc.test.api.enums.CommandType;
import org.npc.test.api.enums.ProductApiMethod;
import org.npc.test.api.enums.ProductApiRequestStatus;
import org.npc.test.api.interfaces.PathElementInterface;
import org.npc.test.api.models.Product;
import org.npc.test.api.models.ProductListing;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductService extends BaseRemoteService {
    public Product getProduct(UUID productId) {

        System.out.println("Insinde getProduct");
        JSONObject rawJsonObject = this.requestSingle(
            (new PathElementInterface[] { ApiLevel.ONE, ProductApiMethod.PRODUCT }), productId
        );

        if (rawJsonObject != null) {
            return (new Product()).loadFromJson(rawJsonObject);
        } else {
            return new Product().setApiRequestStatus(ProductApiRequestStatus.UNKNOWN_ERROR);
        }
    }

    public Product getProductByLookupCode(String lookupCode) {
        JSONObject rawJsonObject = this.requestSingle(
                new PathElementInterface[] {CommandType.PRODUCT,ProductApiMethod.BYLOOKUPCODE},lookupCode
        );

        if (rawJsonObject != null) {
            return (new Product()).loadFromJson(rawJsonObject);
        } else {
            return new Product().setApiRequestStatus(ProductApiRequestStatus.UNKNOWN_ERROR);
        }
    }

    public List<Product> getProducts() {
        List<Product> products;
        JSONObject rawJsonObject = this.requestSingle(
            (new PathElementInterface[] { ApiLevel.ONE, ProductApiMethod.PRODUCTS })
        );

        if (rawJsonObject != null) {
            products = (new ProductListing()).loadFromJson(rawJsonObject).getProducts();
        } else {
            products = new ArrayList<Product>(0);
        }

        return products;
    }

    public Product putProduct(Product product) {
        JSONObject rawJsonObject = this.putSingle(
                (new PathElementInterface[] { ApiLevel.ONE }), product.convertToJson()
        );

        if (rawJsonObject != null) {
            return (new Product()).loadFromJson(rawJsonObject);
        } else {
            return new Product().setApiRequestStatus(ProductApiRequestStatus.UNKNOWN_ERROR);
        }
    }
}
