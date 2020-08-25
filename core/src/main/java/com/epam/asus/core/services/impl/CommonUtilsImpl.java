package com.epam.asus.core.services.impl;

import com.epam.asus.core.services.CommonUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.jetbrains.annotations.*;

import java.util.List;

@Component(immediate = true, service = CommonUtils.class)
public class CommonUtilsImpl implements CommonUtils {
    private static final String LINK_TO = "linkTo";

    @Override
    public boolean isCheckResource(List<Resource> resources) {
        return resources != null && !resources.isEmpty();
    }

    @Override
    public String getPropertyValueByPropertyName(@NotNull final ValueMap properties, final String propertyName) {
        return properties.containsKey(propertyName) ? properties.get(propertyName, String.class) : StringUtils.EMPTY;
    }

    @Override
    public String correctLinkByURLValue(boolean isExternalLink, ValueMap vm){
        return isExternalLink ? getPropertyValueByPropertyName(vm, LINK_TO) : getPropertyValueByPropertyName(vm, LINK_TO).concat(".html");
    }
}
