package com.epam.asus.core.models.beans.article;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class ImagesBean {

    private String fileReference;
}
