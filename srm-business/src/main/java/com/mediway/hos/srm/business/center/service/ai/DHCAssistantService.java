package com.mediway.hos.srm.business.center.service.ai;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DHCAssistantService {
    public String uploadFile(String kbId, MultipartFile file) throws IOException;
}
