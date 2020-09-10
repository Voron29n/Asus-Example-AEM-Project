package com.epam.asus.core.models.beans.product;

import com.epam.asus.core.models.beans.SimpleLinkWithoutTitleBean;
import com.epam.asus.core.utilites.CommonUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class ProductMenuBean {

    public static final String DEFAULT_FONT_AWESOME_MENU_ICON_CLASS = "fas fa-bars";

    @JsonIgnore
    @Getter(AccessLevel.NONE)
    @SlingObject
    private Resource currentResource;
    @ValueMapValue
    private String iconClass;
    @ValueMapValue
    private String menuTitle;

    private SimpleLinkWithoutTitleBean productMenuLink;

    @PostConstruct
    private void init(){
        productMenuLink = currentResource.adaptTo(SimpleLinkWithoutTitleBean.class);
        iconClass = CommonUtils.correctFontAwesomeIconClass(iconClass, DEFAULT_FONT_AWESOME_MENU_ICON_CLASS);
    }
}