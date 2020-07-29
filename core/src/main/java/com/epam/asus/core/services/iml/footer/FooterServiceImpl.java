package com.epam.asus.core.services.iml.footer;

import com.epam.asus.core.models.beans.footer.CopyrightsBean;
import com.epam.asus.core.models.beans.footer.LinksGroupBean;
import com.epam.asus.core.models.beans.footer.SocialsBean;
import com.epam.asus.core.models.impl.footer.LinksGroup;
import com.epam.asus.core.services.FooterService;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = FooterService.class)
public class FooterServiceImpl implements FooterService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private static final String LOGGER_MESSAGE = "ValueMap not found for resource : {}";
    private static final String TYPE_OF_OPEN_PROPERTY_KEY = "typeOfOpen";


    private boolean checkResource(List<Resource> resources){
        return resources != null && !resources.isEmpty();
    }

    private String getPropertyValue(final ValueMap properties, final String propertyName) {
        return properties.containsKey(propertyName) ? properties.get(propertyName, String.class) : StringUtils.EMPTY;
    }

    @Override
    public List<SocialsBean> populateMultiFieldSocialsItems(List<Resource> socials) {
        List<SocialsBean> socialsCol = new ArrayList<>();
        if (checkResource(socials)) {
            for (Resource item : socials) {
                if (item != null) {
                    socialsCol.add(buildSocialsBean(item));
                } else {
                    logger.info(LOGGER_MESSAGE , item);
                }
            }
        }
        return socialsCol;
    }

    private SocialsBean buildSocialsBean(Resource item){
        ValueMap vm = item.getValueMap();
        return SocialsBean.builder()
                .title(getPropertyValue(vm, "title"))
                .linkTo(getPropertyValue(vm, "linkTo"))
                .linkUrlTarget(getPropertyValue(vm, "linkUrlTarget"))
                .fileReference(getPropertyValue(vm, "fileReference"))
                .build();
    }

    @Override
    public List<CopyrightsBean> populateMultiFieldCopyrightItems(List<Resource> copyrights) {
        List<CopyrightsBean> copyrightsCol = new ArrayList<>();
        if (checkResource(copyrights)) {
            for (Resource item : copyrights) {
                if (item != null) {
                    copyrightsCol.add(buildCopyrightBean(item));
                } else {
                    logger.info(LOGGER_MESSAGE , item);
                }
            }
        }
        return copyrightsCol;
    }

    private CopyrightsBean buildCopyrightBean(Resource item){
        ValueMap vm = item.getValueMap();
        boolean isExternalLink = getPropertyValue(vm, "externalLink").equals("true");
        return CopyrightsBean.builder()
                .isExternalLink(isExternalLink)
                .descriptionLink(getPropertyValue(vm, "descriptionLink"))
                .linkTo(correctLinkByURLValue(isExternalLink, vm))
                .linkUrlTarget(getPropertyValue(vm, "linkUrlTarget"))
                .build();
    }

    @Override
    public List<LinksGroupBean> populateMultiFieldFooterGroupLinksItems(List<Resource> footerGroupLinks) {
        List<LinksGroupBean> footerGroupLinksCol = new ArrayList<>();
        if(checkResource(footerGroupLinks)) {
            for (Resource resource : footerGroupLinks) {
                LinksGroup linksGroup = resource.adaptTo(LinksGroup.class);
                assert linksGroup != null;
                footerGroupLinksCol.add(LinksGroupBean.builder()
                                            .groupTitle(linksGroup.getGroupTitle())
                                            .linksNames(linksGroup.getLinksNames())
                                            .build()
                );
            }
        }

        return footerGroupLinksCol;
    }

    private String correctLinkByURLValue(boolean isExternalLink, ValueMap vm){
        if(!isExternalLink){
            return getPropertyValue(vm, "linkTo").concat(".html");
        }else {
            return (getPropertyValue(vm, "linkTo"));
        }
    }


}
