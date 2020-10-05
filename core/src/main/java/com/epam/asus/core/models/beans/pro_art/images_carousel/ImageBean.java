package com.epam.asus.core.models.beans.pro_art.images_carousel;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.day.image.Layer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImageBean {

    @JsonIgnore
    @SlingObject
    private ResourceResolver resourceResolver;

    @ValueMapValue
    private String fileReference;

    @ValueMapValue
    private Long speedMoveImage;

    @ValueMapValue
    private boolean rightSideMove;

    private Long currentWidthImage;

    @PostConstruct
    private void init(){
        setCurrentWidthImage(resourceResolver.getResource(fileReference));
    }

    private void setCurrentWidthImage(Resource imageResource){
        Asset asset = imageResource != null ? imageResource.adaptTo(Asset.class) : null;
        if (asset != null){
            Rendition original = Objects.requireNonNull(asset).getOriginal();
            try {
                currentWidthImage = (long)new Layer(original.getStream()).getWidth();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
