package com.epam.asus.core.models.impl;

import com.epam.asus.core.models.HeroBannerMiddle;
import com.google.gson.Gson;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {HeroBannerMiddle.class},
        resourceType = HeroBannerMiddleImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HeroBannerMiddleImpl implements HeroBannerMiddle {

    protected static final String RESOURCE_TYPE = "asus/components/custom/hero-banner-middle/v1/hero-banner-middle";

    @ValueMapValue
    private boolean isExternalLink;
    @ValueMapValue
    private String linkTo;
    @ValueMapValue
    private String linkUrlTarget;
    @ValueMapValue
    private String fileReference;

    @PostConstruct
    public final void init() {

        if (!isExternalLink) linkTo = linkTo.concat(".html");

    }

    @Override
    public String getModelJson() {
        return new Gson().toJson(this);
    }

    @Override
    public boolean isEmpty() {
        return fileReference == null && linkTo == null;
    }

}