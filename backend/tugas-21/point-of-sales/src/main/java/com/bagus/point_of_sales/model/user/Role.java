package com.bagus.point_of_sales.model.user;

public enum Role {
    CASHIER, MANAGER;

    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
