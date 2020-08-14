package com.epam.asus.core.models.impl.hero;

import com.epam.asus.core.models.HeroBannerMiddle;
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
    private String fileReferenceDesktop;
    @ValueMapValue
    private String fileReferenceMobile;

    @PostConstruct
    public final void init() {

        if (!isExternalLink && linkTo != null) {
            linkTo = linkTo.concat(".html");
        }

    }

    @Override
    public boolean isEmpty() {
        return fileReferenceDesktop == null || fileReferenceMobile == null || linkTo == null;
    }

}