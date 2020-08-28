package com.epam.asus.core.services.pro_art;

import com.epam.asus.core.models.beans.pro_art.categories_nav.CategoryBean;
import org.apache.sling.api.resource.Resource;

import java.util.List;

public interface CategoriesNavService {

    List<CategoryBean> populateMultiFieldCategoryItems(List<Resource> products);
}
