package com.epam.asus.core.services.impl.article;

import com.epam.asus.core.models.beans.article.ImagesBean;
import com.epam.asus.core.services.ArticleService;
import com.epam.asus.core.utilites.CommonUtils;
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
    private static final String FILE_REFERENCE = "fileReference";

    @Override
    public List<ImagesBean> populateMultiFieldImagesItems(List<Resource> images) {
        List<ImagesBean> imagesBeanList = new ArrayList<>();
        if (CommonUtils.isCheckResource(images)) {
            for (Resource item : images) {
                if (item != null) {
                    imagesBeanList.add(buildImagesBean(item));
                } else {
                    logger.info(LOGGER_MESSAGE , images);
                }
            }
        }
        return imagesBeanList;
    }

    @Override
    public List<ImagesBean> adaptMultiFieldImagesItems(List<Resource> images) {
        List<ImagesBean> imagesBeanList = new ArrayList<>();
        if (CommonUtils.isCheckResource(images)) {
            for (Resource item : images) {
                if (item != null) {
                    imagesBeanList.add(item.adaptTo(ImagesBean.class));
                } else {
                    logger.info(LOGGER_MESSAGE , images);
                }
            }
        }
        return imagesBeanList;
    }

    private ImagesBean buildImagesBean(Resource item){
        ValueMap vm = item.getValueMap();
        return ImagesBean.builder()
                .fileReference(CommonUtils.getPropertyValueByPropertyName(vm, FILE_REFERENCE))
                .build();
    }

}
