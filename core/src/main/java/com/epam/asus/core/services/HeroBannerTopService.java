package com.epam.asus.core.services;

import com.epam.asus.core.models.beans.hero_banner_top.ImageBean;
import org.apache.sling.api.resource.Resource;

import java.util.List;

public interface HeroBannerTopService {

    List<ImageBean> populateMultiFieldImageItems(List<Resource> heroImages);
}
