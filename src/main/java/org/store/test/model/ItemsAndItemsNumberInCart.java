package org.store.test.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ItemsAndItemsNumberInCart {
    List<ProductItem> productItemList = new ArrayList<>();
    String itemsNumber;
}
