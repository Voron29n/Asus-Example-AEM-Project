package com.epam.asus.core.models.impl.article;

import com.epam.asus.core.models.ArticleText;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {ArticleText.class},
        resourceType = ArticleTextImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ArticleTextImpl implements ArticleText {

    protected static final String RESOURCE_TYPE = "asus/components/custom/article/article_text/v1/article_text";

    @ValueMapValue
    private String title;
    @ValueMapValue
    private String description;

    @Override
    public boolean isEmpty() {
        return description == null;
    }

}
