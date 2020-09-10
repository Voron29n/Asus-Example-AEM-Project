package com.epam.asus.core.models.beans.hero_banner;

import com.epam.asus.core.utilites.CommonUtils;
import lombok.*;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

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
    @ValueMapValue
    private boolean externalLink;

    @PostConstruct
    public final void init() {
        linkTo = CommonUtils.correctExternalLink(externalLink, linkTo);
    }
}
