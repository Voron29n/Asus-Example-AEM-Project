package com.epam.asus.core.models.impl.article.nav_info_page;

import com.epam.asus.core.models.NavInfoPage;
import com.epam.asus.core.models.beans.nav_info_page.LinksGroupBean;
import com.epam.asus.core.services.NavInfoPageService;
import com.epam.asus.core.utilites.CommonUtils;
import com.google.gson.Gson;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {NavInfoPage.class},
        resourceType = NavInfoPageImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class NavInfoPageImpl implements NavInfoPage {

    protected static final String RESOURCE_TYPE = "asus/components/custom/article/nav-info-page/v1/nav-info-page";

    @Inject
    private NavInfoPageService navInfoPageService;

    @ValueMapValue
    private String title;

    @Inject
    @Via("resource")
    private List<Resource> navInfoPageGroupLinks;

    private List<LinksGroupBean> navInfoPageGroupLinksCol;
    private String navInfoPageGroupLinksJson;

    @PostConstruct
    public final void init() {
        if (CommonUtils.isCheckResource(navInfoPageGroupLinks)) {
            setNavInfoPageGroupLinksCollection(navInfoPageGroupLinks);
            navInfoPageGroupLinksJson = new Gson().toJson(navInfoPageGroupLinksCol);
        }
    }

    private void setNavInfoPageGroupLinksCollection(List<Resource> navInfoPageGroupLinks) {
        navInfoPageGroupLinksCol = navInfoPageService.populateMultiFieldNavInfoPageGroupLinksItems(navInfoPageGroupLinks);
    }

    @Override
    public boolean isEmpty() {
        return title == null || navInfoPageGroupLinksJson == null;
    }
}
