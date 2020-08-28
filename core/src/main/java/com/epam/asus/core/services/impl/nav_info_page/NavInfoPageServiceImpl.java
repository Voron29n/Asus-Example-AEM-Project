package com.epam.asus.core.services.impl.nav_info_page;

import com.epam.asus.core.models.beans.nav_info_page.LinksGroupBean;
import com.epam.asus.core.models.impl.nav_info_page.LinksGroup;
import com.epam.asus.core.utilites.CommonUtils;
import com.epam.asus.core.services.NavInfoPageService;
import org.apache.sling.api.resource.Resource;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, service = NavInfoPageService.class)
public class NavInfoPageServiceImpl implements NavInfoPageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private static final String LOGGER_MESSAGE = "ValueMap not found for resource : {}";

    @Override
    public List<LinksGroupBean> populateMultiFieldNavInfoPageGroupLinksItems(List<Resource> navInfoPageGroupLinks) {
        List<LinksGroupBean> navInfoPageGroupLinksCol = new ArrayList<>();
        if(CommonUtils.isCheckResource(navInfoPageGroupLinks)) {
            for (Resource item : navInfoPageGroupLinks) {
                navInfoPageGroupLinksCol.add(buildLinksGroupBean(item));
            }
        }else {
            logger.debug(LOGGER_MESSAGE , navInfoPageGroupLinks);
        }
        return navInfoPageGroupLinksCol;
    }

    private LinksGroupBean buildLinksGroupBean(Resource item){
        LinksGroup linksGroup = item.adaptTo(LinksGroup.class);
        assert linksGroup != null;
        return LinksGroupBean.builder()
                .groupTitle(linksGroup.getGroupTitle())
                .linksNames(linksGroup.getLinksNames())
                .build();
    }

}
