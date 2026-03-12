package com.mediway.hos.srm.business.center.service.ai;

import com.mediway.hos.srm.business.center.model.dto.ai.ApiDefinition;
import java.util.List;

public interface ApiRegistryService {

    public ApiDefinition getByName(String name);

    public List<ApiDefinition> getAllApis();
}
