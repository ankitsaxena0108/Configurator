package com.prudential.core.common;

import org.springframework.util.StringUtils;

public enum BillingSystemModule {

    CORE(1000, 1999), USER(9000, 9999);
    
    private int minRange;
    private int maxRange;
    
    private BillingSystemModule(int minRange, int maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    public boolean isInValidRange(int number) {
        return number >= minRange & number <= maxRange;
    } 
    
    public static BillingSystemModule module(String errorCode) {
        if (StringUtils.isEmpty(errorCode)) {
            return CORE;
        }
        else {
            int errorNumber = Integer.parseInt(errorCode);
            for (BillingSystemModule module : values()) {
                if (module.isInValidRange(errorNumber)) {
                    return module;
                }
            }
            
            return CORE;
        }
    }
}
