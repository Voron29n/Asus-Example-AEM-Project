package com.epam.asus.core.models.impl.structure.footer;

import com.epam.asus.core.models.Footer;
import com.epam.asus.core.models.beans.footer.CopyrightsBean;
import com.epam.asus.core.models.beans.footer.LinksGroupBean;
import com.epam.asus.core.models.beans.footer.SocialsBean;
import com.epam.asus.core.services.FooterService;
import com.epam.asus.core.utilites.CommonUtils;
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
        adapters = {Footer.class},
        resourceType = FooterImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FooterImpl implements Footer {

    protected static final String RESOURCE_TYPE = "asus/components/custom/structure/footer/v1/footer";

    @Inject
    private FooterService footerService;

    @ValueMapValue
    private boolean isBlackVersion;

    @ValueMapValue
    private String fileReference;
    @ValueMapValue
    private boolean isExternalLink;
    @ValueMapValue
    private String linkUrlTarget;
    @ValueMapValue
    private String linkTo;
    @ValueMapValue
    private String descriptionLink;

    @ValueMapValue
    private String socialTitle;
    @Inject
    @Via("resource")
    private List<Resource> socials;
    @Inject
    @Via("resource")
    private List<Resource> copyrights;
    @Inject
    @Via("resource")
    private List<Resource> footerGroupLinks;

    private List<SocialsBean> socialsCol;
    private List<CopyrightsBean> copyrightsCol;
    private List<LinksGroupBean> footerGroupLinksCol;
    private String socialsJson;
    private String copyrightsJson;
    private String footerGroupLinksJson;

    @PostConstruct
    public final void init() {
        linkTo = CommonUtils.correctExternalLink(isExternalLink, linkTo);
        if (CommonUtils.isCheckResource(socials)) {
            setSocialsCollection(socials);
            socialsJson = new Gson().toJson(socialsCol);
        }
        if (CommonUtils.isCheckResource(copyrights)) {
            setCopyrightsCollections(copyrights);
            copyrightsJson = new Gson().toJson(copyrightsCol);
        }
        if (CommonUtils.isCheckResource(footerGroupLinks)) {
            setFooterGroupLinksCollection(footerGroupLinks);
            footerGroupLinksJson = new Gson().toJson(footerGroupLinksCol);
        }
    }

    private void setFooterGroupLinksCollection(List<Resource> footerGroupLinks) {
        footerGroupLinksCol = footerService.populateMultiFieldFooterGroupLinksItems(footerGroupLinks);
    }
    private void setSocialsCollection(List<Resource> socials){
        socialsCol = footerService.populateMultiFieldSocialsItems(socials);
    }
    private void setCopyrightsCollections(List<Resource> copyrights) {
        copyrightsCol = footerService.populateMultiFieldCopyrightItems(copyrights);
    }

    @Override
    public boolean isEmpty() {
        return descriptionLink == null;
    }
}
