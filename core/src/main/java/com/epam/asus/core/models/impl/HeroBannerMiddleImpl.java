package com.epam.asus.core.models.impl;

import com.epam.asus.core.models.HeroBannerMiddle;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = "asus/components/custom/hero-banner-middle/v1/hero-banner-middle"
)
public class HeroBannerMiddleImpl implements HeroBannerMiddle {

//    @SlingObject
//    private Resource currentResource;

    @ValueMapValue
    private boolean isExternalLink;
    @ValueMapValue
    private String linkTo;
    @ValueMapValue
    private String linkUrlTarget;

//    @Inject
//    @Via("resource")
    @ValueMapValue
    private String fileReference;

    @PostConstruct
    public final void init() {

        if (!isExternalLink) linkTo = linkTo.concat(".html");

    }

    @Override
    public boolean isEmpty() {
        return fileReference == null && linkTo == null;
    }

}