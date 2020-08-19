package com.epam.asus.core.models.impl.hot_product_groups;

import com.epam.asus.core.models.HotProductGroups;
import com.epam.asus.core.models.beans.hot_product_groups.ProductBean;
import com.epam.asus.core.services.HotProductGroupsService;
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
        adapters = {HotProductGroups.class},
        resourceType = HotProductGroupsImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HotProductGroupsImpl implements HotProductGroups {

    protected static final String RESOURCE_TYPE = "asus/components/custom/hot-product-groups/v1/hot-product-groups";

    @Inject
    private HotProductGroupsService hotProductGroupsService;

    @ValueMapValue
    private String groupsTitle;

    @Inject
    @Via("resource")
    private List<Resource> hotProductGroups;

    private List<ProductBean> productsCol;
    private String hotProductGroupsJson;

    @PostConstruct
    public final void init() {
        if (checkListResource(hotProductGroups)) setHotProductGroupsCollection(hotProductGroups);
        hotProductGroupsJson = new Gson().toJson(productsCol);
    }

    private boolean checkListResource(List<Resource> resources) {
        return resources != null && !resources.isEmpty();
    }

    private void setHotProductGroupsCollection(List<Resource> hotProductGroups) {
        productsCol = hotProductGroupsService.populateMultiFieldHotProductItems(hotProductGroups);
    }

    @Override
    public boolean isEmpty() {
        return groupsTitle == null && productsCol == null;
    }

}
