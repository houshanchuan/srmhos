package com.mediway.hos.srm.business.center.serviceimpl.wx;

import com.mediway.hos.security.core.HosGrantType;
import com.mediway.hos.security.core.HosGrantType;
import com.mediway.hos.security.core.authentication.AbstractHosAuthenticationToken;

public class HosFSAuthenticationToken extends AbstractHosAuthenticationToken<HosFSLoginParam>{

        //必要代码
        @Override
        public Object getCredentials() {
            return null;
        }
        //必要代码
        @Override
        public Object getPrincipal() {
            return null;
        }
        //必要代码
        private HosFSAuthenticationToken() {
            super();
        }
        //必要代码
        public HosFSAuthenticationToken(HosFSLoginParam loginParam) {

            super(loginParam, new HosGrantType("FSToken"));
        }



}
