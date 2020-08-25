package com.epam.asus.core.services;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import java.util.List;

public interface CommonUtils {

    boolean isCheckResource(List<Resource> resources);
    String getPropertyValueByPropertyName(final ValueMap properties, final String propertyName);
    String correctLinkByURLValue(boolean isExternalLink, ValueMap vm);
}
