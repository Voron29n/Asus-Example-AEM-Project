package com.epam.asus.core.models.impl.pro_art.categories_nav;

import com.epam.asus.core.models.ProArtCategoriesNav;
import com.epam.asus.core.models.beans.pro_art.categories_nav.CategoryBean;
import com.epam.asus.core.services.pro_art.CategoriesNavService;
import com.epam.asus.core.utilites.CommonUtils;
import com.google.gson.Gson;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {ProArtCategoriesNav.class},
        resourceType = CategoriesNavImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CategoriesNavImpl implements ProArtCategoriesNav {

    protected static final String RESOURCE_TYPE = "asus/components/custom/proart/categories_nav/v1/categories_nav";

    @Inject
    private CategoriesNavService categoriesNavService;

    @ValueMapValue
    private String title;

    @Inject
    @Via("resource")
    private List<Resource> categories;

    private List<CategoryBean> categoriesCol;
    private String categoriesNavJson;

    @PostConstruct
    public final void init() {
        if (CommonUtils.isCheckResource(categories)) {
            setProductsNavCollection(categories);
            categoriesNavJson = new Gson().toJson(categoriesCol);
        }
    }

    private void setProductsNavCollection(List<Resource> categories) {
        categoriesCol = categoriesNavService.populateMultiFieldCategoryItems(categories);
    }

    @Override
    public boolean isEmpty() {
        return categoriesNavJson == null;
    }
}
