package com.szmtjk.web.authentication.controller;

import com.szmtjk.authentication.model.OAuth;
import com.szmtjk.authentication.model.OAuthQuery;
import com.szmtjk.authentication.service.OAuthService;
import com.szmtjk.business.service.base.BaseService;
import com.szmtjk.web.controller.base.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/oAuth")
@RestController
public class OAuthController extends BaseCRUDController<OAuth,OAuthQuery>{
    @Autowired
    @Qualifier(value = "oauthServiceImpl")
    private OAuthService oAuthService;

    @Override
    protected BaseService<OAuth, OAuthQuery> getBaseService() {
        return this.oAuthService;
    }
}