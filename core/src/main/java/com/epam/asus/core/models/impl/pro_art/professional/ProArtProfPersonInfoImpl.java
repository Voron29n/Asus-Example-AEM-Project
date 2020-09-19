package com.epam.asus.core.models.impl.pro_art.professional;

import com.epam.asus.core.models.ProArtProfPersonInfo;
import com.epam.asus.core.models.beans.pro_art.professional.PersonInfoBean;
import com.epam.asus.core.utilites.View;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {ProArtProfPersonInfo.class},
        resourceType = ProArtProfPersonInfoImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ProArtProfPersonInfoImpl implements ProArtProfPersonInfo {

    protected static final String RESOURCE_TYPE = "asus/components/custom/proart/professional/person-info/v1/person-info";

    @SlingObject
    private Resource currentResource;

    private String personDataJson;

    @PostConstruct
    private void init() throws JsonProcessingException {
        PersonInfoBean personInfoBean = currentResource.adaptTo(PersonInfoBean.class);

        personDataJson = personInfoBean.isEmpty() ? "" : new ObjectMapper().writerWithView(View.PersonInfo.class).writeValueAsString(personInfoBean);
    }

    @Override
    public boolean isEmpty() {
        return StringUtils.isEmpty(personDataJson);
    }

}
