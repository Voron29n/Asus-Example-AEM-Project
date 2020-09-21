package com.epam.asus.core.models.beans.pro_art.professional;

import com.epam.asus.core.utilites.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Getter
@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PersonInfoBean {

    @JsonIgnore
    @SlingObject
    private Resource currentResource;

    @JsonView(value = View.PersonImg.class)
    @ValueMapValue
    private String fileReference;
    @JsonView(value = View.PersonImg.class)
    @ValueMapValue
    private String resourcePath;

    @JsonView(value = View.PersonInfo.class)
    @ValueMapValue
    private String firstNameRu;
    @JsonView(value = View.PersonInfo.class)
    @ValueMapValue
    private String lastNameRu;
    @JsonView(value = View.PersonInfo.class)
    @ValueMapValue
    private String firstNameEn;
    @JsonView(value = View.PersonInfo.class)
    @ValueMapValue
    private String lastNameEn;
    @JsonView(value = View.PersonInfo.class)
    @ValueMapValue
    private String professionPosition;

    @PostConstruct
    private void init() {
        resourcePath = currentResource.getPath();
    }

    @JsonIgnore
    public boolean isEmpty() {
        return StringUtils.isBlank(firstNameRu)
                || StringUtils.isBlank(firstNameEn)
                || StringUtils.isBlank(lastNameRu)
                || StringUtils.isBlank(lastNameEn)
                || StringUtils.isBlank(professionPosition);
    }

    @JsonIgnore
    public boolean isEmptyWithImg() {
        return StringUtils.isBlank(fileReference)
                || StringUtils.isBlank(resourcePath)
                || this.isEmpty();
    }
}
