package com.epam.asus.core.models.beans;

import com.epam.asus.core.utilites.CommonUtils;
import lombok.Getter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Getter
@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SimpleLinkWithoutTitleBean {

    @ValueMapValue
    private String linkTo;
    @ValueMapValue
    private String linkUrlTarget;
    @ValueMapValue
    private boolean isExternalLink;

    @PostConstruct
    private void init(){
        linkTo = CommonUtils.correctExternalLink(isExternalLink, linkTo);
    }

    public boolean isEmpty(){
        return linkTo == null || linkUrlTarget == null;
    }
}
