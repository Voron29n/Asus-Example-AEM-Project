package com.epam.asus.core.models.beans.footer;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class CopyrightsBean{

    private boolean isExternalLink;
    private String descriptionLink;
    private String linkTo;
    private String linkUrlTarget;

}
