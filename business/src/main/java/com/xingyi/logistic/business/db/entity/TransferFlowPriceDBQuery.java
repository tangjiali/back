package com.xingyi.logistic.business.db.entity;

import com.xingyi.logistic.business.bean.BaseDBQueryPage;

/**
 * 运价流向信息
 */
public class TransferFlowPriceDBQuery extends BaseDBQueryPage {

    private Long transferPriceId;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getTransferPriceId() {
        return transferPriceId;
    }

    public void setTransferPriceId(Long transferPriceId) {
        this.transferPriceId = transferPriceId;
    }
}
