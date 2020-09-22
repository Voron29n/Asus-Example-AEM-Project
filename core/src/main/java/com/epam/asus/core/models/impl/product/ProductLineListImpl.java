package com.epam.asus.core.models.impl.product;

import com.epam.asus.core.models.ProductLineList;
import com.epam.asus.core.models.beans.product.ProductItemBean;
import com.epam.asus.core.models.beans.product.ProductMenuBean;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
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
@Exporter(name = "jackson", extensions = "json", options = { @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value = "true") })
public class ProductLineListImpl implements ProductLineList {

    protected static final String RESOURCE_TYPE = "asus/components/custom/product/product-line-list/v1/product-line-list";

    @JsonIgnore
    @SlingObject
    private Resource currentResource;

    @JsonIgnore
    @Inject
    @Via("resource")
    private List<Resource> productList;

    private String productMenuBeanJson;

    private String productLineListCollectionJson;

    private List<ProductItemBean> productLineList;

    @PostConstruct
    private void init() throws JsonProcessingException {
        ProductMenuBean productMenuBean = currentResource.adaptTo(ProductMenuBean.class);
        productLineList = productList.stream()
                .map(productItem -> productItem.adaptTo(ProductItemBean.class))
                .collect(Collectors.toList());

        productMenuBeanJson = new ObjectMapper().writeValueAsString(productMenuBean);
        productLineListCollectionJson = new ObjectMapper().writeValueAsString(productLineList);
    }

    @Override
    public boolean isEmpty() {
        return productLineListCollectionJson == null || productMenuBeanJson == null;
    }
}
