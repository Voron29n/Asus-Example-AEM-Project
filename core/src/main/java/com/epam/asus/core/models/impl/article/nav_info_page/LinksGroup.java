package com.epam.asus.core.models.impl.article.nav_info_page;

import com.epam.asus.core.utilites.CommonUtils;
import lombok.Getter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Getter
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinksGroup {

    @Inject
    private String groupTitle;

    @Inject
    @Named("navInfoPageLinksGroup")
    private List<Resource> navInfoPageLinksGroup;

    private List<LinksNames> linksNames;

    @PostConstruct
    public final void init() {
        if(CommonUtils.isCheckResource(navInfoPageLinksGroup)){
            linksNames = new ArrayList<>();
            for (Resource resource : navInfoPageLinksGroup) {
                LinksNames linksName = resource.adaptTo(LinksNames.class);
                this.linksNames.add(linksName);
            }
        }
    }

}
