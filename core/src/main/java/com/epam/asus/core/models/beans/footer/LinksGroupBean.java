package com.epam.asus.core.models.beans.footer;

import com.epam.asus.core.models.impl.structure.footer.LinksNames;
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
