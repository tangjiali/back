package com.xingyi.logistic.authentication.bean;

import com.xingyi.logistic.business.bean.BaseModelAndDO;

public class BaseRoleResources extends BaseModelAndDO{
    private Long roleId;
    private Long resourceId;
    private Integer isDeleted;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
