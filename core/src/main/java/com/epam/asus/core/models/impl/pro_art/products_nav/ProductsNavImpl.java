package com.epam.asus.core.models.impl.pro_art.products_nav;

import com.epam.asus.core.models.ProArtProductsNav;
import com.epam.asus.core.models.beans.pro_art.products_nav.ProductBean;
import com.epam.asus.core.services.pro_art.ProductsNavService;
import com.google.gson.Gson;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {ProArtProductsNav.class},
        resourceType = ProductsNavImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ProductsNavImpl implements ProArtProductsNav {

    protected static final String RESOURCE_TYPE = "asus/components/custom/proart/products_nav/v1/products_nav";

    @Inject
    private ProductsNavService productsNavService;

    @Inject
    @Via("resource")
    private List<Resource> products;

    private List<ProductBean> productsCol;
    private String productsNavJson;

    @PostConstruct
    public final void init() {
        if (checkListResource(products)) setProductsNavCollection(products);
        productsNavJson = new Gson().toJson(productsCol);
    }

    private boolean checkListResource(List<Resource> resources) {
        return resources != null && !resources.isEmpty();
    }

    private void setProductsNavCollection(List<Resource> products) {
        productsCol = productsNavService.populateMultiFieldProductItems(products);
    }

    @Override
    public boolean isEmpty() {
        return productsCol == null;
    }
}
