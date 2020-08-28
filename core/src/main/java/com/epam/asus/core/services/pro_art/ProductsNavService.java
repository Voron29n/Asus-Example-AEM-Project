package com.epam.asus.core.services.pro_art;

import com.epam.asus.core.models.beans.pro_art.products_nav.ProductBean;
import org.apache.sling.api.resource.Resource;

import java.util.List;

public interface ProductsNavService {

    List<ProductBean> populateMultiFieldProductItems(List<Resource> products);
}
