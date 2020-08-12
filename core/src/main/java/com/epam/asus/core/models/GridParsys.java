package com.epam.asus.core.models;

import java.util.List;

public interface GridParsys {

    boolean isEmpty();

    int getNumberParsysMobileVersion();

    int getNumberParsysDesktopVersion();

    List<String> getParsysNames();
}
