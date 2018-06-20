package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.PlanRefueling;
import com.xingyi.logistic.business.model.PlanRefuelingQuery;
import com.xingyi.logistic.business.model.PreBuckleOil;
import com.xingyi.logistic.business.model.PreBuckleOilQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.PlanRefuelingService;
import com.xingyi.logistic.business.service.PreBuckleOilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * wzf
 */
@RestController
@RequestMapping("/planRefueling")
public class PlanRefuelingController extends BaseCRUDController<PlanRefueling, PlanRefuelingQuery> {

    @Autowired
    private PlanRefuelingService planRefuelingService;

    @Override
    protected BaseService<PlanRefueling, PlanRefuelingQuery> getBaseService() {
        return planRefuelingService;
    }
}