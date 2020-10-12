package com.epam.asus.core.models.impl.pro_art.professional;

import com.day.cq.wcm.api.Page;
import com.epam.asus.core.models.ProArtProfPersonInfo;
import com.epam.asus.core.models.beans.pro_art.professional.PersonInfoBean;
import com.epam.asus.core.utilites.CommonUtils;
import com.epam.asus.core.utilites.View;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {ProArtProfPersonInfo.class},
        resourceType = ProArtProfPersonInfoImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ProArtProfPersonInfoImpl implements ProArtProfPersonInfo {

    protected static final String RESOURCE_TYPE = "asus/components/custom/proart/professional/person-info/v1/person-info";

    private static final String PERSON_PAGE_PATH = "personPagePath";
    private static final boolean IS_EXTERNAL_LINK = false;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @SlingObject
    private Resource currentResource;

    @SlingObject
    private ResourceResolver resourceResolver;

    @ScriptVariable
    private Page currentPage;

    private String personDataJson;

    @PostConstruct
    private void init() throws JsonProcessingException {
        boolean isPersonPagePathBlank = StringUtils.isBlank((String) currentResource.getValueMap().get(PERSON_PAGE_PATH));

        if (isPersonPagePathBlank) {
            setPersonPagePath();
        }

        PersonInfoBean personInfoBean = currentResource.adaptTo(PersonInfoBean.class);

        personDataJson = personInfoBean.isEmpty()
                ? ""
                : new ObjectMapper()
                .writerWithView(View.PersonInfo.class)
                .writeValueAsString(personInfoBean);
    }

    @Override
    public boolean isEmpty() {
        return StringUtils.isEmpty(personDataJson);
    }

    private void setPersonPagePath() {
        try {
            Node node = currentResource.adaptTo(Node.class);
            Session session = resourceResolver.adaptTo(Session.class);

            if (node != null && session != null) {
                String personPagePath = CommonUtils.correctExternalLink(IS_EXTERNAL_LINK, currentPage.getPath());

                node.setProperty(PERSON_PAGE_PATH, personPagePath);

                session.save();
            }
        } catch (RepositoryException e) {
            logger.warn("can not add a property: {}", PERSON_PAGE_PATH);
        }
    }

}
