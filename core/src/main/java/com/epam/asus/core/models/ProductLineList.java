package com.epam.asus.core.models;

import com.epam.asus.core.models.beans.product.ProductItemBean;

import java.util.List;

public interface ProductLineList {

    String getProductMenuBeanJson();

    String getProductLineListCollectionJson();

    boolean isEmpty();

    List<ProductItemBean> getProductLineList();

}
