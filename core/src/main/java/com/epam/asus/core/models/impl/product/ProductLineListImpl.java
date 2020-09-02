package com.epam.asus.core.models.impl.product;

import com.epam.asus.core.models.ProductLineList;
import com.epam.asus.core.models.beans.product.ProductItemBean;
import com.epam.asus.core.models.beans.product.ProductMenuBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {ProductLineList.class},
        resourceType = ProductLineListImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ProductLineListImpl implements ProductLineList {

    protected static final String RESOURCE_TYPE = "asus/components/custom/product/product-line-list/v1/product-line-list";

    @SlingObject
    private Resource currentResource;

    @Inject
    @Via("resource")
    private List<Resource> productList;

    private String productMenuBeanJson;

    private String productLineListCollectionJson;

    @PostConstruct
    private void init() {
        ProductMenuBean productMenuBean = currentResource.adaptTo(ProductMenuBean.class);
        List<ProductItemBean> productLineList = productList.stream()
                .map(productItem -> productItem.adaptTo(ProductItemBean.class))
                .collect(Collectors.toList());
        Gson gson = getGson();
        productMenuBeanJson = gson.toJson(productMenuBean);
        productLineListCollectionJson = gson.toJson(productLineList);
    }

    @NotNull
    private Gson getGson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

    @Override
    public boolean isEmpty() {
        return productLineListCollectionJson == null || productMenuBeanJson == null;
    }
}
