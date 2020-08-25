package com.epam.asus.core.services.impl.pro_art.products_nav;

import com.epam.asus.core.models.beans.pro_art.products_nav.ProductBean;
import com.epam.asus.core.services.CommonUtils;
import com.epam.asus.core.services.pro_art.ProductsNavService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = ProductsNavService.class)
public class ProductsNavServiceImpl implements ProductsNavService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private static final String LOGGER_MESSAGE = "ValueMap not found for resource : {}";
    private static final String FILE_REFERENCE_SMALL = "fileReferenceSmall";
    private static final String FILE_REFERENCE_MEDIUM = "fileReferenceMedium";
    private static final String FILE_REFERENCE_LARGE = "fileReferenceLarge";
    private static final String TITLE = "title";
    private static final String LINK_TO = "linkTo";
    private static final String LINK_URL_TARGET = "linkUrlTarget";
    private static final String DESCRIPTION = "description";

    @Reference
    protected CommonUtils commonUtils;

    @Override
    public List<ProductBean> populateMultiFieldProductItems(List<Resource> products) {
        List<ProductBean> productsCol = new ArrayList<>();
        if (commonUtils.isCheckResource(products)) {
            for (Resource item : products) {
                if (item != null) {
                    productsCol.add(buildProductBean(item));
                }else {
                    logger.debug(LOGGER_MESSAGE , products);
                }
            }
        }
        return productsCol;
    }

    private ProductBean buildProductBean(Resource item){
        ValueMap vm = item.getValueMap();
        return ProductBean.builder()
                .fileReferenceSmall(commonUtils.getPropertyValueByPropertyName(vm, FILE_REFERENCE_SMALL))
                .fileReferenceMedium(commonUtils.getPropertyValueByPropertyName(vm, FILE_REFERENCE_MEDIUM))
                .fileReferenceLarge(commonUtils.getPropertyValueByPropertyName(vm, FILE_REFERENCE_LARGE))
                .title(commonUtils.getPropertyValueByPropertyName(vm, TITLE))
                .description(commonUtils.getPropertyValueByPropertyName(vm, DESCRIPTION))
                .linkTo(commonUtils.getPropertyValueByPropertyName(vm, LINK_TO))
                .linkUrlTarget(commonUtils.getPropertyValueByPropertyName(vm, LINK_URL_TARGET))
                .build();
    }

}
