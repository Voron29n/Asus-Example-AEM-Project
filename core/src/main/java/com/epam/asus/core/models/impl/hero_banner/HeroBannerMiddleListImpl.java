package com.epam.asus.core.models.impl.hero_banner;

import com.epam.asus.core.models.HeroBannerMiddleList;
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
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {HeroBannerMiddleList.class},
        resourceType = HeroBannerMiddleListImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HeroBannerMiddleListImpl implements HeroBannerMiddleList {

    protected static final String RESOURCE_TYPE = "asus/components/custom/hero-banner/hero-banner-middle-list/v1/hero-banner-middle-list";

    @Inject
    private HeroBannerService heroBannerService;

    @Inject
    @Via("resource")
    private List<Resource> heroImages;
    @ValueMapValue
    private boolean isCycle;

    private List<ImageBean> heroImagesCollection;
    private String heroBannerMiddleListCollectionJson;

    @PostConstruct
    public final void init() {
        if (CommonUtils.isCheckResource(heroImages)) {
            setHeroImagesCollection(heroImages);
            heroBannerMiddleListCollectionJson = new Gson().toJson(heroImagesCollection);
        }
    }

    private void setHeroImagesCollection(List<Resource> heroImages){
        heroImagesCollection = heroBannerService.adaptResourceToMultiFieldImageItems(heroImages);
    }

    @Override
    public boolean isEmpty() {
        return heroBannerMiddleListCollectionJson == null;
    }

}
