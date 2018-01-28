package com.xingyi.logistic.authentication.service.impl;

import com.xingyi.logistic.authentication.db.dao.UserRolesDAO;
import com.xingyi.logistic.authentication.db.entity.UserRolesDBQuery;
import com.xingyi.logistic.authentication.db.entity.UserRolesDO;
import com.xingyi.logistic.authentication.model.UserProfile;
import com.xingyi.logistic.authentication.model.UserRoles;
import com.xingyi.logistic.authentication.model.UserRolesQuery;
import com.xingyi.logistic.authentication.service.UserRolesService;
import com.xingyi.logistic.authentication.service.converter.UserRolesConverter;
import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.UserRolesQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserRolesServiceImpl extends BaseCRUDService<UserRolesDO,UserRoles,UserRolesDBQuery,UserRolesQuery> implements UserRolesService {

    @Autowired
    private UserRolesDAO userRolesDAO;

    @Autowired
    private UserRolesConverter userRolesConverter;

    @Autowired
    private UserRolesQueryConverter userRolesQueryConverter;

    @Override
    protected ModelConverter<UserRolesDO, UserRoles> getModelConverter() {
        return this.userRolesConverter;
    }

    @Override
    protected BaseDAO<UserRolesDO, UserRolesDBQuery> getDAO() {
        return this.userRolesDAO;
    }

    @Override
    protected QueryConditionConverter<UserRolesQuery, UserRolesDBQuery> getConditionConverter() {
        return this.userRolesQueryConverter;
    }

    @Override
    public void deleteByUserId(Long userId){
        this.userRolesDAO.deleteByUserId(userId);
    }

    @Override
    public int setRoles(Long userId, List<Long> roleIds){
        int effectRows = 0;
        UserProfile signinProfile = SessionUtil.getSubject().getUser().getProfile();
        UserRoles ur = null;

        this.deleteByUserId(userId);

        if(!CollectionUtils.isEmpty(roleIds)){
            for(Long roleId:roleIds){
                ur = new UserRoles();
                ur.setCreator(signinProfile.getId());
                ur.setCreatorName(signinProfile.getRealName());
                ur.setUpdater(signinProfile.getId());
                ur.setUpdaterName(signinProfile.getRealName());
                ur.setUserId(userId);
                ur.setRoleId(roleId);
                effectRows += this.userRolesDAO.insertSelective(this.userRolesConverter.toDataObject(ur));
            }
        }
        return effectRows;
    }
}
