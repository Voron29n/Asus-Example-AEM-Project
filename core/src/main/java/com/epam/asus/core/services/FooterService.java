package com.epam.asus.core.services;


import com.epam.asus.core.models.beans.footer.CopyrightsBean;
import com.epam.asus.core.models.beans.footer.LinksGroupBean;
import com.epam.asus.core.models.beans.footer.SocialsBean;
import org.apache.sling.api.resource.Resource;

import java.util.List;

public interface FooterService {

    List<SocialsBean> populateMultiFieldSocialsItems(List<Resource> socials);
    List<CopyrightsBean> populateMultiFieldCopyrightItems(List<Resource> copyrights);
    List<LinksGroupBean> populateMultiFieldFooterGroupLinksItems(List<Resource> footerGroupLinks);
}
