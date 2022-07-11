package com.sambit.Entity;

public class GepNIC {
    private String status;
    private String statusReason;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    @Override
    public String toString() {
        return "GepNIC{" +
                "status='" + status + '\'' +
                ", statusReason='" + statusReason + '\'' +
                '}';
    }
}
