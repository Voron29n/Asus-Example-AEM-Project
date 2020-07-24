package com.epam.asus.core.models;

import com.epam.asus.core.models.impl.HeroBannerMiddleImpl;

public interface HeroBannerMiddle {

    String getModelJson();

    boolean isEmpty();

    boolean isExternalLink();

    String getLinkTo();

    String getLinkUrlTarget();
}
