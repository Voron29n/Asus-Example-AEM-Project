package com.epam.asus.core.services.impl.footer;

import com.epam.asus.core.models.beans.footer.CopyrightsBean;
import com.epam.asus.core.models.beans.footer.LinksGroupBean;
import com.epam.asus.core.models.beans.footer.SocialsBean;
import com.epam.asus.core.models.impl.footer.LinksGroup;
import com.epam.asus.core.utilites.CommonUtils;
import com.epam.asus.core.services.FooterService;
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
    private static final String FILE_REFERENCE = "fileReference";
    private static final String TITLE = "title";
    private static final String LINK_TO = "linkTo";
    private static final String LINK_URL_TARGET = "linkUrlTarget";
    private static final String EXTERNAL_LINK = "externalLink";
    private static final String DESCRIPTION_LINK = "descriptionLink";

    @Override
    public List<SocialsBean> populateMultiFieldSocialsItems(List<Resource> socials) {
        List<SocialsBean> socialsCol = new ArrayList<>();
        if (CommonUtils.isCheckResource(socials)) {
            for (Resource item : socials) {
                if (item != null) {
                    socialsCol.add(buildSocialsBean(item));
                } else {
                    logger.info(LOGGER_MESSAGE , socials);
                }
            }
        }
        return socialsCol;
    }

    private SocialsBean buildSocialsBean(Resource item){
        ValueMap vm = item.getValueMap();
        return SocialsBean.builder()
                .title(CommonUtils.getPropertyValueByPropertyName(vm, TITLE))
                .linkTo(CommonUtils.getPropertyValueByPropertyName(vm, LINK_TO))
                .linkUrlTarget(CommonUtils.getPropertyValueByPropertyName(vm, LINK_URL_TARGET))
                .fileReference(CommonUtils.getPropertyValueByPropertyName(vm, FILE_REFERENCE))
                .build();
    }

    @Override
    public List<CopyrightsBean> populateMultiFieldCopyrightItems(List<Resource> copyrights) {
        List<CopyrightsBean> copyrightsCol = new ArrayList<>();
        if (CommonUtils.isCheckResource(copyrights)) {
            for (Resource item : copyrights) {
                if (item != null) {
                    copyrightsCol.add(buildCopyrightBean(item));
                } else {
                    logger.info(LOGGER_MESSAGE , copyrights);
                }
            }
        }
        return copyrightsCol;
    }

    private CopyrightsBean buildCopyrightBean(Resource item){
        ValueMap vm = item.getValueMap();
        boolean isExternalLink = CommonUtils.getPropertyValueByPropertyName(vm, EXTERNAL_LINK).equals("true");
        return CopyrightsBean.builder()
                .descriptionLink(CommonUtils.getPropertyValueByPropertyName(vm, DESCRIPTION_LINK))
                .isExternalLink(isExternalLink)
                .linkTo(CommonUtils.correctLinkByURLValue(isExternalLink, vm))
                .linkUrlTarget(CommonUtils.getPropertyValueByPropertyName(vm, LINK_URL_TARGET))
                .build();
    }

    @Override
    public List<LinksGroupBean> populateMultiFieldFooterGroupLinksItems(List<Resource> footerGroupLinks) {
        List<LinksGroupBean> footerGroupLinksCol = new ArrayList<>();
        if(CommonUtils.isCheckResource(footerGroupLinks)) {
            for (Resource resource : footerGroupLinks) {
                LinksGroup linksGroup = resource.adaptTo(LinksGroup.class);
                assert linksGroup != null;
                footerGroupLinksCol.add(LinksGroupBean.builder()
                                            .groupTitle(linksGroup.getGroupTitle())
                                            .linksNames(linksGroup.getLinksNames())
                                            .build()
                );
            }
        }else {
            logger.info(LOGGER_MESSAGE , footerGroupLinks);
        }
        return footerGroupLinksCol;
    }
}
