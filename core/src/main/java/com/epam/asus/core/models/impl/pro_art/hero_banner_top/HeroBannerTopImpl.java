package com.epam.asus.core.models.impl.pro_art.hero_banner_top;

import com.epam.asus.core.models.ProArtHeroBannerTop;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {ProArtHeroBannerTop.class},
        resourceType = HeroBannerTopImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HeroBannerTopImpl implements ProArtHeroBannerTop {

    protected static final String RESOURCE_TYPE = "asus/components/custom/proart/hero-banner-top/v1/hero-banner-top";

    @ValueMapValue
    private String title;
    @ValueMapValue
    private String fileReferenceSmall;
    @ValueMapValue
    private String fileReferenceMedium;
    @ValueMapValue
    private String fileReferenceLarge;

    @Override
    public boolean isEmpty() {
        return fileReferenceLarge == null;
    }

}