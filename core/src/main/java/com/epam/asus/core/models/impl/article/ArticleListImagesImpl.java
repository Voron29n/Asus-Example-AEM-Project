package com.epam.asus.core.models.impl.article;

import com.epam.asus.core.models.ArticleListImages;
import com.epam.asus.core.models.beans.article.ImagesBean;
import com.epam.asus.core.services.ArticleService;
import com.google.gson.Gson;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {ArticleListImages.class},
        resourceType = ArticleListImagesImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ArticleListImagesImpl implements ArticleListImages {

    protected static final String RESOURCE_TYPE = "asus/components/custom/article/article_images/v1/article_images";

    @ValueMapValue
    private String title;

    @Inject
    private ArticleService articleService;

    @Inject
    @Via("resource")
    private List<Resource> images;

    private List<ImagesBean> imagesBeanList;
    private String imagesJson;

    @PostConstruct
    public final void init() {
        if (checkListResource(images)) {
            setImagesBeanList(images);
            imagesJson = new Gson().toJson(imagesBeanList);
        }
    }

    private boolean checkListResource(List<Resource> resources) {
        return resources != null && !resources.isEmpty();
    }

    private void setImagesBeanList(List<Resource> images) {
        imagesBeanList = articleService.populateMultiFieldImagesItems(images);
    }

    @Override
    public boolean isEmpty() {
        return imagesJson == null;
    }

}
