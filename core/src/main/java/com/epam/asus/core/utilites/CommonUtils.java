package com.epam.asus.core.utilites;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CommonUtils {
    private CommonUtils() {}

    private static final String LINK_TO = "linkTo";
    private static final String HTML = ".html";

    private static final String FONT_AWESOME_ICON_PATTERN_WITH_HTML = "^<i class=\"fa[a-z] fa.+\"><\\/i>";
    private static final String FONT_AWESOME_ICON_PATTERN_WITHOUT_HTML = "^fa[a-z] fa.+";
    private static final String FONT_AWESOME_PATTERN_CLASS = "fa[a-z] fa.+[^(\"><\\/i>)]";


    public static <T> T getValue(Object obj, Class<T> clazz) {
        return (T) obj;
    }

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

    public static String correctFontAwesomeIconClass(String iconClassProp, String defaultIconClass){
        String iconClassData = null;
        if (isIconClassWithHtml(iconClassProp)) {
             iconClassData = cutIconClassFromHtmlWithIconClass(iconClassProp);
        } else if (isIconClassWithoutHtml(iconClassProp)) {
            iconClassData = iconClassProp;
        } else {
            iconClassData = defaultIconClass;
        }
        return iconClassData;
    }

    private static boolean isIconClassWithoutHtml(String iconClassProp) {
        Pattern fontAwesomePattern = Pattern.compile(FONT_AWESOME_ICON_PATTERN_WITHOUT_HTML);
        Matcher fontAwesomeMatcher = fontAwesomePattern.matcher(iconClassProp);
        return fontAwesomeMatcher.find();
    }

    private static String cutIconClassFromHtmlWithIconClass(String iconClassProp) {
        Pattern fontAwesomePattern = Pattern.compile(FONT_AWESOME_PATTERN_CLASS);
        Matcher fontAwesomeMatcher = fontAwesomePattern.matcher(iconClassProp);
        return fontAwesomeMatcher.find() ? iconClassProp.substring(fontAwesomeMatcher.start(),fontAwesomeMatcher.end()) : "";
    }

    private static boolean isIconClassWithHtml(String iconClass) {
        Pattern fontAwesomePattern = Pattern.compile(FONT_AWESOME_ICON_PATTERN_WITH_HTML);
        Matcher fontAwesomeMatcher = fontAwesomePattern.matcher(iconClass);
        return fontAwesomeMatcher.find();
    }
}
