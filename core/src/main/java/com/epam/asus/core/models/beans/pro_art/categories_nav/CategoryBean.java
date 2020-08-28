package com.epam.asus.core.models.beans.pro_art.categories_nav;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class CategoryBean {

    private String fileReferenceDesktop;
    private String fileReferenceMobile;
    private String title;
    private String linkTo;
    private String linkUrlTarget;
}
