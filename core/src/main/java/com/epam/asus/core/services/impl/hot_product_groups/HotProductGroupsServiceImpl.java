package com.epam.asus.core.services.impl.hot_product_groups;

import com.epam.asus.core.models.beans.hot_product_groups.ProductBean;
import com.epam.asus.core.services.HotProductGroupsService;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = HotProductGroupsService.class)
public class HotProductGroupsServiceImpl implements HotProductGroupsService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private static final String LOGGER_MESSAGE = "ValueMap not found for resource : {}";

    private boolean checkResource(List<Resource> resources){
        return resources != null && !resources.isEmpty();
    }

    private String getPropertyValue(final ValueMap properties, final String propertyName) {
        return properties.containsKey(propertyName) ? properties.get(propertyName, String.class) : StringUtils.EMPTY;
    }

    @Override
    public List<ProductBean> populateMultiFieldHotProductItems(List<Resource> products) {
        List<ProductBean> productsCol = new ArrayList<>();
        if (checkResource(products)) {
            for (Resource item : products) {
                if (item != null) {
                    productsCol.add(buildProductBean(item));
                } else {
                    logger.info(LOGGER_MESSAGE , item);
                }
            }
        }
        return productsCol;
    }

    private ProductBean buildProductBean(Resource item){
        ValueMap vm = item.getValueMap();
        return ProductBean.builder()
                .fileReference(getPropertyValue(vm, "fileReference"))
                .title(getPropertyValue(vm, "title"))
                .descriptionLink(getPropertyValue(vm, "descriptionLink"))
                .linkTo(getPropertyValue(vm, "linkTo"))
                .linkUrlTarget(getPropertyValue(vm, "linkUrlTarget"))
                .build();
    }

}
