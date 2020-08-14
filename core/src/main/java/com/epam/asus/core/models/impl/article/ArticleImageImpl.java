package com.epam.asus.core.models.impl.article;

import com.epam.asus.core.models.ArticleImage;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {ArticleImage.class},
        resourceType = ArticleImageImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ArticleImageImpl implements ArticleImage {

    protected static final String RESOURCE_TYPE = "asus/components/custom/article/article_image/v1/article_image";

    @ValueMapValue
    private String fileReference;

    @Override
    public boolean isEmpty() {
        return fileReference == null;
    }

}
