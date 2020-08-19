package com.epam.asus.core.models.beans.hot_product_groups;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class ProductBean {

    private String fileReference;
    private String title;
    private String descriptionLink;
    private String linkTo;
    private String linkUrlTarget;

}
