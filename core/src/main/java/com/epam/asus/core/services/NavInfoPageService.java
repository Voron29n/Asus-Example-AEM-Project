package com.epam.asus.core.services;


import com.epam.asus.core.models.beans.nav_info_page.LinksGroupBean;
import org.apache.sling.api.resource.Resource;

import java.util.List;

public interface NavInfoPageService {

    List<LinksGroupBean> populateMultiFieldNavInfoPageGroupLinksItems(List<Resource> navInfoPageGroupLinks);
}
