package com.epam.asus.core.services;


import com.epam.asus.core.models.beans.article.ImagesBean;
import org.apache.sling.api.resource.Resource;

import java.util.List;

public interface ArticleService {

    List<ImagesBean> populateMultiFieldImagesItems(List<Resource> images);

    List<ImagesBean> adaptMultiFieldImagesItems(List<Resource> images);

}
