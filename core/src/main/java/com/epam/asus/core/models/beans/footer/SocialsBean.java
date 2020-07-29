package com.epam.asus.core.models.beans.footer;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class SocialsBean {

    private String title;
    private String linkTo;
    private String linkUrlTarget;
    private String fileReference;
}
