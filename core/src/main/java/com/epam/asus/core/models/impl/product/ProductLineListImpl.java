package com.epam.asus.core.models.impl.product;

import com.epam.asus.core.models.ProductLineList;
import com.epam.asus.core.models.beans.product.ProductItemBean;
import com.epam.asus.core.models.beans.product.ProductMenuBean;
import com.epam.asus.core.utilites.CommonUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {ProductLineList.class},
        resourceType = ProductLineListImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson",
          extensions = "json",
          options = {
                @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS",value = "true"),
                @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true")
})
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
        productLineList = CommonUtils.adaptListResourcesToListBeans(productList, ProductItemBean.class);

        productMenuBeanJson = new ObjectMapper().writeValueAsString(productMenuBean);
        productLineListCollectionJson = new ObjectMapper().writeValueAsString(productLineList);
    }

    @Override
    public boolean isEmpty() {
        return productLineListCollectionJson == null || productMenuBeanJson == null;
    }
}
