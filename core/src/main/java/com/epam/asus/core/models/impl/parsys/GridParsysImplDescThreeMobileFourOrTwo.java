package com.epam.asus.core.models.impl.parsys;

import com.epam.asus.core.models.GridParsys;
import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Getter
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        adapters = {GridParsys.class},
        resourceType = GridParsysImplDescThreeMobileFourOrTwo.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class GridParsysImplDescThreeMobileFourOrTwo implements GridParsys {

    /* Parsys node name */
    public static final String PARSYS_NODE_NAME = "par_";
    protected static final String RESOURCE_TYPE = "asus/components/custom/parsys/desc-3_mobile-4_or_2";
    /* Desctope 3 tabs 3col. 1 row / Mobile version 4 tabs 2 col. 2 row */
    private static final String NORMAL_PARSYS_TYPE = "NORMAL";
    /* Desctope 3 tabs 3col. 1 row / Mobile version 4 tabs 2 col. 1 row */
    private static final String SIMPLIFIED_PARSYS_TYPE = "SIMPLIFIED";
    @ValueMapValue
    private String parsysType;

    private int numberParsysMobileVersion;
    private int numberParsysDesktopVersion;

    private List<String> parsysNames;

    @PostConstruct
    public final void init() {
        if (parsysType != null) {

            numberParsysDesktopVersion = 3;

            switch (parsysType) {
                case NORMAL_PARSYS_TYPE:
                    numberParsysMobileVersion = 4;
                    break;
                case SIMPLIFIED_PARSYS_TYPE:
                    numberParsysMobileVersion = 2;
                    break;
                default:
                    //FIXME add logger
            }

            parsysNames = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                parsysNames.add(PARSYS_NODE_NAME + String.valueOf(i));
            }
        }
    }


    @Override
    public boolean isEmpty() {
        return parsysType == null;
    }
}
