package com.epam.asus.core.models.beans.hero_banner;

import lombok.*;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImageBean {
    @ValueMapValue
    private String fileReferenceDesktop;
    @ValueMapValue
    private String fileReferenceMobile;
    @ValueMapValue
    private String descriptionLink;
    @ValueMapValue
    private String linkTo;
    @ValueMapValue
    private String linkUrlTarget;

}
