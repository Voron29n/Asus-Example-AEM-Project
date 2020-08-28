package com.epam.asus.core.services.impl.hero_banner_top;

import com.epam.asus.core.models.beans.hero_banner_top.ImageBean;
import com.epam.asus.core.servlets.CommonUtils;
import com.epam.asus.core.services.HeroBannerTopService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = HeroBannerTopService.class)
public class HeroBannerTopServiceImpl implements HeroBannerTopService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private static final String LOGGER_MESSAGE = "ValueMap not found for resource : {}";
    private static final String FILE_REFERENCE_DESKTOP = "fileReferenceDesktop";
    private static final String FILE_REFERENCE_MOBILE = "fileReferenceMobile";
    private static final String LINK_URL_TARGET = "linkUrlTarget";
    private static final String EXTERNAL_LINK = "externalLink";
    private static final String DESCRIPTION_LINK = "descriptionLink";

    @Override
    public List<ImageBean> populateMultiFieldImageItems(List<Resource> heroImages) {
        List<ImageBean> heroImagesCollection = new ArrayList<>();
        if (CommonUtils.isCheckResource(heroImages)) {
            for (Resource item : heroImages) {
                if (item != null) {
                    heroImagesCollection.add(buildImageBean(item));
                } else {
                    logger.info(LOGGER_MESSAGE , heroImages);
                }
            }
        }
        return heroImagesCollection;
    }

    private ImageBean buildImageBean(Resource item){
        ValueMap vm = item.getValueMap();
        boolean isExternalLink = CommonUtils.getPropertyValueByPropertyName(vm, EXTERNAL_LINK).equals("true");
        return ImageBean.builder()
                .fileReferenceDesktop(CommonUtils.getPropertyValueByPropertyName(vm, FILE_REFERENCE_DESKTOP))
                .fileReferenceMobile(CommonUtils.getPropertyValueByPropertyName(vm, FILE_REFERENCE_MOBILE))
                .descriptionLink(CommonUtils.getPropertyValueByPropertyName(vm, DESCRIPTION_LINK))
                .linkTo(CommonUtils.correctLinkByURLValue(isExternalLink, vm))
                .linkUrlTarget(CommonUtils.getPropertyValueByPropertyName(vm, LINK_URL_TARGET))
                .build();
    }

}
