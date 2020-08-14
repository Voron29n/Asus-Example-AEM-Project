package com.epam.asus.core.models.impl.article;

import com.epam.asus.core.models.ArticleImageText;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {ArticleImageText.class},
        resourceType = ArticleImageTextImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ArticleImageTextImpl implements ArticleImageText {

    protected static final String RESOURCE_TYPE = "asus/components/custom/article/article_image_text/v1/article_image_text";

    @ValueMapValue
    private String title;
    @ValueMapValue
    private String description;
    @ValueMapValue
    private String fileReference;
    @ValueMapValue
    private boolean imageRightSide;

    @Override
    public boolean isEmpty() {
        return description == null || fileReference == null;
    }

}
