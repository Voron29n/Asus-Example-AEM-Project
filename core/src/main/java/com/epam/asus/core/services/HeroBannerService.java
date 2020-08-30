package com.epam.asus.core.services;

import com.epam.asus.core.models.beans.hero_banner.ImageBean;
import org.apache.sling.api.resource.Resource;

import java.util.List;

public interface HeroBannerService {

    List<ImageBean> populateMultiFieldImageItems(List<Resource> heroImages);

    List<ImageBean> adaptResourceToMultiFieldImageItems(List<Resource> heroImages);
}
