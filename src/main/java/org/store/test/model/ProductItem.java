package org.store.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor
public class ProductItem implements Comparable<ProductItem> {
    String name;
    String price;

    public Float floatPrice() {
        float value = 0.00F;
        Pattern pattern = Pattern.compile(".*\\$(\\d.*)");
        Matcher m = pattern.matcher(price);
        if(m.matches()) {
            value = Float.parseFloat(m.group(1));
        }
        return value;
    }

    @Override
    public int compareTo(ProductItem o) {
        return this.floatPrice().compareTo(o.floatPrice());
    }
}
