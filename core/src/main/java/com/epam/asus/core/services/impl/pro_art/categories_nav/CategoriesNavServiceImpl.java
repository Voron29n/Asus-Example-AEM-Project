package com.epam.asus.core.services.impl.pro_art.categories_nav;

import com.epam.asus.core.models.beans.pro_art.categories_nav.CategoryBean;
import com.epam.asus.core.services.pro_art.CategoriesNavService;
import com.epam.asus.core.utilites.CommonUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = CategoriesNavService.class)
public class CategoriesNavServiceImpl implements CategoriesNavService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private static final String LOGGER_MESSAGE = "ValueMap not found for resource : {}";
    private static final String FILE_REFERENCE_DESKTOP = "fileReferenceDesktop";
    private static final String FILE_REFERENCE_MOBILE = "fileReferenceMedium";
    private static final String TITLE = "title";
    private static final String LINK_TO = "linkTo";
    private static final String LINK_URL_TARGET = "linkUrlTarget";

    @Override
    public List<CategoryBean> populateMultiFieldCategoryItems(List<Resource> categories) {
        List<CategoryBean> categoriesCol = new ArrayList<>();
        if (CommonUtils.isCheckResource(categories)) {
            for (Resource item : categories) {
                if (item != null) {
                    categoriesCol.add(buildCategoryBean(item));
                }else {
                    logger.debug(LOGGER_MESSAGE , categories);
                }
            }
        }
        return categoriesCol;
    }

    private CategoryBean buildCategoryBean(Resource item){
        ValueMap vm = item.getValueMap();
        return CategoryBean.builder()
                .fileReferenceDesktop(CommonUtils.getPropertyValueByPropertyName(vm, FILE_REFERENCE_DESKTOP))
                .fileReferenceMobile(CommonUtils.getPropertyValueByPropertyName(vm, FILE_REFERENCE_MOBILE))
                .title(CommonUtils.getPropertyValueByPropertyName(vm, TITLE))
                .linkTo(CommonUtils.getPropertyValueByPropertyName(vm, LINK_TO))
                .linkUrlTarget(CommonUtils.getPropertyValueByPropertyName(vm, LINK_URL_TARGET))
                .build();
    }

}
