package com.mediway.hos.srm.business.center.serviceimpl.wx;
import com.mediway.hos.security.core.authentication.param.AbstractHosLoginParam;
import lombok.Data;

@Data
public class HosFSLoginParam extends AbstractHosLoginParam{
    private String token;
}
