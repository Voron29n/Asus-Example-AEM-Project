package com.epam.asus.core.models.impl.hero_banner;

import com.epam.asus.core.models.HeroBannerSmall;
import com.epam.asus.core.models.beans.SimpleLinkWithoutTitleBean;
import com.google.gson.Gson;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {HeroBannerSmall.class},
        resourceType = HeroBannerSmallImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HeroBannerSmallImpl implements HeroBannerSmall {

    protected static final String RESOURCE_TYPE = "asus/components/custom/hero-banner/hero-banner-small/v1/hero-banner-small";

    @SlingObject
    private Resource currentResource;

    @ValueMapValue
    private String heroDescription;
    @ValueMapValue
    private String heroTitle;
    @ValueMapValue
    private String fileReference;

    private String jsonOfLinkData;

    @PostConstruct
    public final void init() {
        jsonOfLinkData = new Gson().toJson(currentResource.adaptTo(SimpleLinkWithoutTitleBean.class));
    }

    @Override
    public boolean isEmpty() {
        return heroTitle == null || fileReference == null || heroDescription == null;
    }
}

