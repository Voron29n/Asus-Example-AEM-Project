package com.epam.asus.core.services.impl.hot_product_groups;

import com.epam.asus.core.models.beans.hot_product_groups.ProductBean;
import com.epam.asus.core.services.CommonUtils;
import com.epam.asus.core.services.HotProductGroupsService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = HotProductGroupsService.class)
public class HotProductGroupsServiceImpl implements HotProductGroupsService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private static final String LOGGER_MESSAGE = "ValueMap not found for resource : {}";
    private static final String FILE_REFERENCE = "fileReference";
    private static final String TITLE = "title";
    private static final String LINK_TO = "linkTo";
    private static final String LINK_URL_TARGET = "linkUrlTarget";
    private static final String DESCRIPTION_LINK = "descriptionLink";

    @Reference
    protected CommonUtils commonUtils;

    @Override
    public List<ProductBean> populateMultiFieldHotProductItems(List<Resource> products) {
        List<ProductBean> productsCol = new ArrayList<>();
        if (commonUtils.isCheckResource(products)) {
            for (Resource item : products) {
                if (item != null) {
                    productsCol.add(buildProductBean(item));
                } else {
                    logger.debug(LOGGER_MESSAGE , products);
                }
            }
        }
        return productsCol;
    }

    private ProductBean buildProductBean(Resource item){
        ValueMap vm = item.getValueMap();
        return ProductBean.builder()
                .fileReference(commonUtils.getPropertyValueByPropertyName(vm, FILE_REFERENCE))
                .title(commonUtils.getPropertyValueByPropertyName(vm, TITLE))
                .descriptionLink(commonUtils.getPropertyValueByPropertyName(vm, DESCRIPTION_LINK))
                .linkTo(commonUtils.getPropertyValueByPropertyName(vm, LINK_TO))
                .linkUrlTarget(commonUtils.getPropertyValueByPropertyName(vm, LINK_URL_TARGET))
                .build();
    }

}
