package com.epam.asus.core.models;

public interface Footer {

    boolean isEmpty();

    String getLinkUrlTarget();
    String getLinkTo();
    String getDescriptionLink();
    String getFileReference();


    String getSocialTitle();
    String getSocialsJson();
    String getCopyrightsJson();
    String getFooterGroupLinksJson();
}
