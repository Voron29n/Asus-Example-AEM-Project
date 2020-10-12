package com.epam.asus.core.services.impl.pro_art.professional;

import com.epam.asus.core.models.beans.pro_art.professional.PersonInfoBean;
import com.epam.asus.core.services.pro_art.ProArtProfessional;
import com.epam.asus.core.utilites.QueryUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(
        service = ProArtProfessional.class,
        immediate = true)
public class ProArtProfessionalImpl implements ProArtProfessional {

    private static final String PROFESSION_PAGE_QUERY_PATTERN_SQL2 =
            "SELECT * FROM [cq:Page] AS cqP WHERE ISDESCENDANTNODE(cqP,{0}) " +
                    "AND cqP.[jcr:content/cq:lastReplicationAction] = {1} " +
                    "AND cqP.[jcr:content/cq:template] = {2} " +
                    "ORDER BY cqP.[jcr:content/jcr:created]";

    private static final String PERSON_INFO_QUERY_PATTERN_SQL2 =
            "SELECT * FROM [nt:unstructured] AS perInf WHERE ISDESCENDANTNODE(perInf,{0}) " +
                    "AND perInf.[sling:resourceType] = {1}";

    private static final String SERVICE_USER_NAME = "search-user";

    private static final String PAGE_PROPERTY_STATUS_ACTION_VALUE = "Activate";
    private static final String PAGE_PROPERTY_TEMPLATE_VALUE = "/conf/asus/settings/wcm/templates/page-content-ProArt-Professional";

    private static final String PERSON_INFO_PROPERTY_RESOURCE_TYPE_VALUE = "asus/components/custom/proart/professional/person-info/v1/person-info";

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Reference
    private ResourceResolverFactory resolverFactory;

    private Session session;
    private ResourceResolver resolver;
    private QueryManager queryManager;

    @Override
    public List<PersonInfoBean> getPersonInfoBeans(String searchPath, int searchLimit) {
        List<PersonInfoBean> foundBeans = new ArrayList<>();

        if (!loginJCR()) {
            return null;
        }

        try {
            queryManager = session.getWorkspace().getQueryManager();

            QueryResult result = searchProfessionalPage(searchPath, searchLimit);

            javax.jcr.NodeIterator nodeItem = result.getNodes();

            while (nodeItem.hasNext()) {
                javax.jcr.Node pageNode = nodeItem.nextNode();

                Resource personInfo = searchPersonInfo(pageNode.getPath());

                if (personInfo != null) {
                    foundBeans.add(personInfo.adaptTo(PersonInfoBean.class));
                }
            }

        } catch (RepositoryException e) {
            logger.error("Problems with SearchService at make query to JCR with next massage: {}", e.getMessage());
        }

        logoutJCR();

        return foundBeans;
    }

    private QueryResult searchProfessionalPage(String searchPath, int searchLimit) throws RepositoryException {
        String[] searchArgs = {searchPath, PAGE_PROPERTY_STATUS_ACTION_VALUE, PAGE_PROPERTY_TEMPLATE_VALUE};

        String sqlStatement = QueryUtils.createSqlStatement(PROFESSION_PAGE_QUERY_PATTERN_SQL2, searchArgs);

        return QueryUtils.getQueryResult(queryManager, sqlStatement, searchLimit);
    }

    private Resource searchPersonInfo(String searchPath) throws RepositoryException {
        String[] searchArg = {searchPath, PERSON_INFO_PROPERTY_RESOURCE_TYPE_VALUE};

        String sqlStatement = QueryUtils.createSqlStatement(PERSON_INFO_QUERY_PATTERN_SQL2, searchArg);

        QueryResult result = QueryUtils.getQueryResult(queryManager, sqlStatement);

        javax.jcr.NodeIterator nodeItem = result.getNodes();

        if (nodeItem.hasNext()) {
            javax.jcr.Node node = nodeItem.nextNode();
            return resolver.getResource(node.getPath());
        }

        return null;
    }

    private boolean loginJCR() {
        try {
            resolver = getResourceResolver();
            session = resolver.adaptTo(Session.class);
        } catch (LoginException e) {
            logger.error("Problems to get a Session with user: {}", SERVICE_USER_NAME);
            return false;
        }
        return true;
    }

    private void logoutJCR() {
        if (session.isLive() && resolver.isLive()) {
            session.logout();
            resolver.close();
        }
    }

    private ResourceResolver getResourceResolver() throws LoginException {

        Map<String, Object> param = new HashMap<>();
        param.put(ResourceResolverFactory.SUBSERVICE, SERVICE_USER_NAME);

        return resolverFactory.getServiceResourceResolver(param);
    }
}

