package com.epam.asus.core.utilites;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class CommonUtils {
    private CommonUtils() {}

    private static final String LINK_TO = "linkTo";
    private static final String HTML = ".html";

    public static boolean isCheckResource(final List<Resource> resources) {
        return resources != null && !resources.isEmpty();
    }

    public static String correctExternalLink(boolean isExternalLink, String linkTo){
        return !isExternalLink && linkTo != null ? linkTo.concat(HTML) : linkTo;
    }

    public static String getPropertyValueByPropertyName(@NotNull final ValueMap properties, final String propertyName) {
        return properties.containsKey(propertyName) ? properties.get(propertyName, String.class) : StringUtils.EMPTY;
    }

    public static String correctLinkByURLFromValueMap(final boolean isExternalLink, final ValueMap vm){
        return isExternalLink ? getPropertyValueByPropertyName(vm, LINK_TO) : getPropertyValueByPropertyName(vm, LINK_TO).concat(HTML);
    }
}
