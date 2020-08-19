package com.epam.asus.core.services;

import com.epam.asus.core.models.beans.hot_product_groups.ProductBean;
import org.apache.sling.api.resource.Resource;

import java.util.List;

public interface HotProductGroupsService {

    List<ProductBean> populateMultiFieldHotProductItems(List<Resource> products);
}
