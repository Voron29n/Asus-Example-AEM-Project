package com.epam.asus.core.services.impl.hero_banner_top;

import com.epam.asus.core.models.beans.hero_banner_top.ImageBean;
import com.epam.asus.core.services.HeroBannerTopService;
import org.apache.commons.lang.StringUtils;
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

    private boolean checkResource(List<Resource> resources){
        return resources != null && !resources.isEmpty();
    }

    private String getPropertyValue(final ValueMap properties, final String propertyName) {
        return properties.containsKey(propertyName) ? properties.get(propertyName, String.class) : StringUtils.EMPTY;
    }

    @Override
    public List<ImageBean> populateMultiFieldImageItems(List<Resource> heroImages) {
        List<ImageBean> heroImagesCollection = new ArrayList<>();
        if (checkResource(heroImages)) {
            for (Resource item : heroImages) {
                if (item != null) {
                    heroImagesCollection.add(buildImageBean(item));
                } else {
                    logger.info(LOGGER_MESSAGE , item);
                }
            }
        }
        return heroImagesCollection;
    }

    private ImageBean buildImageBean(Resource item){
        ValueMap vm = item.getValueMap();
        boolean isExternalLink = getPropertyValue(vm, "externalLink").equals("true");
        return ImageBean.builder()
                .fileReference(getPropertyValue(vm, "fileReference"))
                .descriptionLink(getPropertyValue(vm, "descriptionLink"))
                .linkTo(correctLinkByURLValue(isExternalLink, vm))
                .linkUrlTarget(getPropertyValue(vm, "linkUrlTarget"))
                .build();
    }

    private String correctLinkByURLValue(boolean isExternalLink, ValueMap vm){
        if(!isExternalLink){
            return getPropertyValue(vm, "linkTo").concat(".html");
        }else {
            return (getPropertyValue(vm, "linkTo"));
        }
    }

}
