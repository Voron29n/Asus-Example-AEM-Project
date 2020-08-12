package com.epam.asus.core.services.iml.article;

import com.epam.asus.core.models.beans.article.ImagesBean;
import com.epam.asus.core.services.ArticleService;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = ArticleService.class)
public class ArticleServiceImpl implements ArticleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private static final String LOGGER_MESSAGE = "ValueMap not found for resource : {}";

    private boolean checkResource(List<Resource> resources){
        return resources != null && !resources.isEmpty();
    }

    private String getPropertyValue(final ValueMap properties) {
        return properties.containsKey("fileReference") ? properties.get("fileReference", String.class) : StringUtils.EMPTY;
    }

    @Override
    public List<ImagesBean> populateMultiFieldImagesItems(List<Resource> images) {
        List<ImagesBean> imagesBeanList = new ArrayList<>();
        if (checkResource(images)) {
            for (Resource item : images) {
                if (item != null) {
                    imagesBeanList.add(buildImagesBean(item));
                } else {
                    logger.info(LOGGER_MESSAGE , item);
                }
            }
        }
        return imagesBeanList;
    }

    private ImagesBean buildImagesBean(Resource item){
        ValueMap vm = item.getValueMap();
        return ImagesBean.builder()
                .fileReference(getPropertyValue(vm))
                .build();
    }

}
