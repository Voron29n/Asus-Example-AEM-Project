package com.epam.asus.core.services.pro_art;

import com.epam.asus.core.models.beans.pro_art.professional.PersonInfoBean;

import java.util.List;

public interface ProArtProfessional {

    List<PersonInfoBean> getPersonInfoBeans(String searchPath, int searchLimit);
}
