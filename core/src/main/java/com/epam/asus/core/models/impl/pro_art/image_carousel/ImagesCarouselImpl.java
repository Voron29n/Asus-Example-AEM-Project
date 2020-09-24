package com.epam.asus.core.models.impl.pro_art.image_carousel;

import com.epam.asus.core.models.ProArtImagesCarousel;
import com.epam.asus.core.models.beans.pro_art.images_carousel.ImageBean;
import com.epam.asus.core.utilites.CommonUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {ProArtImagesCarousel.class},
        resourceType = ImagesCarouselImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson",
          extensions = "json",
          options = {
                @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS",value = "true"),
                @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true")
})
public class ImagesCarouselImpl implements ProArtImagesCarousel {

    protected static final String RESOURCE_TYPE = "asus/components/custom/proart/images-carousel/v1/images-carousel";

    @ValueMapValue
    private String title;

    @JsonIgnore
    @SlingObject
    private Resource currentResource;

    @JsonIgnore
    @Inject
    @Via("resource")
    private List<Resource> imagesResource;

    private List<ImageBean> imagesList;

    @PostConstruct
    private void init() {
        imagesList = CommonUtils.adaptListResourcesToListBeans(imagesResource, ImageBean.class);
    }

    @JsonIgnore
    @Override
    public boolean isEmpty() {
        return title == null || imagesList == null;
    }
}
