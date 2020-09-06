package com.epam.asus.core.models.beans.product;

import com.epam.asus.core.models.beans.SimpleLinkWithoutTitleBean;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Getter
@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProductItemBean {

    @JsonIgnore
    @Getter(AccessLevel.NONE)
    @SlingObject
    private Resource currentResource;

    @ValueMapValue
    private String fileReference;
    @ValueMapValue
    private String productTitle;
    @ValueMapValue
    private String productDescription;

    private SimpleLinkWithoutTitleBean productItemLink;

    @PostConstruct
    private void init(){
        productItemLink = currentResource.adaptTo(SimpleLinkWithoutTitleBean.class);
    }

}
