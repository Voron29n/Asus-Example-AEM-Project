package com.epam.asus.core.models.beans.nav_info_page;

import com.epam.asus.core.models.impl.structure.nav_info_page.LinksNames;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class LinksGroupBean {

    private String groupTitle;
    private List<LinksNames> linksNames;
}
