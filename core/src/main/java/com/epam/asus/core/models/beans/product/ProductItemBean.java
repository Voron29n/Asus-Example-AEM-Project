package com.epam.asus.core.models.beans.product;

import com.epam.asus.core.models.beans.SimpleLinkWithoutTitleBean;
import com.google.gson.annotations.Expose;
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

    @Getter(AccessLevel.NONE)
    @SlingObject
    private Resource currentResource;

    @Expose
    @ValueMapValue
    private String fileReference;
    @Expose
    @ValueMapValue
    private String productTitle;
    @Expose
    @ValueMapValue
    private String productDescription;
    @Expose
    private SimpleLinkWithoutTitleBean productMenuLink;

    @PostConstruct
    private void init(){
        productMenuLink = currentResource.adaptTo(SimpleLinkWithoutTitleBean.class);
    }

}
