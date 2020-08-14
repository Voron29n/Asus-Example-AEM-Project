package com.epam.asus.core.models.impl.article;

import com.epam.asus.core.models.ArticleTitle;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {ArticleTitle.class},
        resourceType = ArticleTitleImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ArticleTitleImpl implements ArticleTitle{

    protected static final String RESOURCE_TYPE = "asus/components/custom/article/article_title/v1/article_title";

    @ValueMapValue
    private String title;
    @ValueMapValue
    private String description;

    @ValueMapValue
    private boolean isExternalLink;
    @ValueMapValue
    private String linkUrlTarget;
    @ValueMapValue
    private String linkTo;
    @ValueMapValue
    private String descriptionLink;

    @PostConstruct
    public final void init() {
        if (!isExternalLink && linkTo != null) {
            linkTo = linkTo.concat(".html");
        }
    }

    @Override
    public boolean isEmpty() {
        return title == null;
    }

}
