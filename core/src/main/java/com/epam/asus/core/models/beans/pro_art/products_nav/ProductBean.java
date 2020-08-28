package com.epam.asus.core.models.beans.pro_art.products_nav;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class ProductBean {

    private String fileReferenceSmall;
    private String fileReferenceMedium;
    private String fileReferenceLarge;
    private String title;
    private String description;
    private String linkTo;
    private String linkUrlTarget;

}
