package com.epam.asus.core.models.impl.article;

import com.epam.asus.core.models.CustomizedText;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {CustomizedText.class},
        resourceType = CustomizedTextImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CustomizedTextImpl implements CustomizedText {

    protected static final String RESOURCE_TYPE = "apps/asus/components/custom/article/customized-text/v1/customized-text";

    @ValueMapValue
    private String title;
    @ValueMapValue
    private String description;

    @Override
    public boolean isEmpty() {
        return title == null && description == null;
    }

}
