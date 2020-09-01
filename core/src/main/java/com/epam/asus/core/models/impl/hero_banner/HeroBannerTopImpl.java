package com.epam.asus.core.models.impl.hero_banner;

import com.epam.asus.core.models.HeroBannerTop;

import com.epam.asus.core.models.beans.hero_banner.ImageBean;
import com.epam.asus.core.services.HeroBannerService;
import com.epam.asus.core.utilites.CommonUtils;
import com.google.gson.Gson;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {HeroBannerTop.class},
        resourceType = HeroBannerTopImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HeroBannerTopImpl implements HeroBannerTop {

    protected static final String RESOURCE_TYPE = "asus/components/custom/hero-banner/hero-banner-top/v1/hero-banner-top";

    @Inject
    private HeroBannerService heroBannerService;

    @Inject
    @Via("resource")
    private List<Resource> heroImages;

    private List<ImageBean> heroImagesCollection;
    private String heroBannerTopCollectionJson;

    @PostConstruct
    public final void init() {
        if (CommonUtils.isCheckResource(heroImages)) {
            setHeroImagesCollection(heroImages);
            heroBannerTopCollectionJson = new Gson().toJson(heroImagesCollection);
        }
    }

    private void setHeroImagesCollection(List<Resource> heroImages){
        heroImagesCollection = heroBannerService.populateMultiFieldImageItems(heroImages);
    }

    @Override
    public boolean isEmpty() {
        return heroBannerTopCollectionJson == null;
    }

}
