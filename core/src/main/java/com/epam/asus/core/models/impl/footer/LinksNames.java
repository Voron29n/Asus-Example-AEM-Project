package com.epam.asus.core.models.impl.footer;

import com.epam.asus.core.utilites.CommonUtils;
import lombok.Getter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Getter
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinksNames {

    @ValueMapValue
    private boolean isExternalLink;
    @ValueMapValue
    private String descriptionLink;
    @ValueMapValue
    private String linkTo;
    @ValueMapValue
    private String linkUrlTarget;

    @PostConstruct
    public final void init() {
        linkTo = CommonUtils.correctExternalLink(isExternalLink, linkTo);
    }
}
