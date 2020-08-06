package com.epam.asus.core.models;

import com.epam.asus.core.models.beans.footer.CopyrightsBean;
import com.epam.asus.core.models.beans.footer.LinksGroupBean;
import com.epam.asus.core.models.beans.footer.SocialsBean;

import java.util.List;

public interface Footer {

    boolean isEmpty();

    String getLinkUrlTarget();
    String getLinkTo();
    String getDescriptionLink();
    String getFileReference();


    String getSocialTitle();
    List<SocialsBean> getSocialsCol();
    List<CopyrightsBean> getCopyrightsCol();
    List<LinksGroupBean> getFooterGroupLinksCol();

    String getFooterGroupLinksJson();
}
