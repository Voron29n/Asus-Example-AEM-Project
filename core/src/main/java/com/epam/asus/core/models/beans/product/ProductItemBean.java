package com.epam.asus.core.models.beans.product;

import com.epam.asus.core.models.beans.SimpleLinkWithoutTitleBean;
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
    @SlingObject
    private Resource currentResource;
    @ValueMapValue
    private String fileReference;
    @ValueMapValue
    private String productTitle;
    @ValueMapValue
    private String productDescription;

    private SimpleLinkWithoutTitleBean productMenuLink;

    @PostConstruct
    private void init(){
        productMenuLink = currentResource.adaptTo(SimpleLinkWithoutTitleBean.class);
    }

}
