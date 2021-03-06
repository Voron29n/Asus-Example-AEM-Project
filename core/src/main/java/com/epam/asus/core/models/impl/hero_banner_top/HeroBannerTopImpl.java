package com.epam.asus.core.models.impl.hero_banner_top;

import com.epam.asus.core.models.HeroBannerTop;
import com.epam.asus.core.models.beans.hero_banner_top.ImageBean;
import com.epam.asus.core.services.HeroBannerTopService;
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

    protected static final String RESOURCE_TYPE = "asus/components/custom/hero-banner-top/v1/hero-banner-top";

    @Inject
    private HeroBannerTopService heroBannerTopService;

    @Inject
    @Via("resource")
    private List<Resource> heroImages;

    private List<ImageBean> heroImagesCollection;
    private String heroBannerTopCollectionJson;

    @PostConstruct
    public final void init() {
        if (checkListResource(heroImages)) {
            setHeroImagesCollection(heroImages);
            heroBannerTopCollectionJson = new Gson().toJson(heroImagesCollection);
        }
    }

    private boolean checkListResource(List<Resource> resources) {
        return resources != null && !resources.isEmpty();
    }

    private void setHeroImagesCollection(List<Resource> heroImages){
        heroImagesCollection = heroBannerTopService.populateMultiFieldImageItems(heroImages);
    }

    @Override
    public boolean isEmpty() {
        return heroBannerTopCollectionJson == null;
    }

}
