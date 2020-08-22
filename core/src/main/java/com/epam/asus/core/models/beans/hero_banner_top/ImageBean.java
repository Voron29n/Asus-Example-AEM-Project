package com.epam.asus.core.models.beans.hero_banner_top;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class ImageBean {

    private String fileReference;
    private String descriptionLink;
    private String linkTo;
    private String linkUrlTarget;

}
