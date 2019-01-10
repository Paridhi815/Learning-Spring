package com.learnspring.demo.DTO;

//Request
public class UnderwritingSection {
    private String claims;
    private Integer numberOfClaims;
    private String isSeasonal;
    private String haveFrier;
    private String isDoughnut;
    private String isDeliveryProvider;

    public UnderwritingSection() {
    }

    public String getClaims() {
        return claims;
    }

    public void setClaims(String claims) {
        this.claims = claims;
    }

    public String getIsSeasonal() {
        return isSeasonal;
    }

    public void setIsSeasonal(String isSeasonal) {
        this.isSeasonal = isSeasonal;
    }


    public String getIsDoughnut() {
        return isDoughnut;
    }

    public void setIsDoughnut(String isDoughnut) {
        this.isDoughnut = isDoughnut;
    }

    public String getIsDeliveryProvider() {
        return isDeliveryProvider;
    }

    public void setIsDeliveryProvider(String isDeliveryProvider) {
        this.isDeliveryProvider = isDeliveryProvider;
    }

    public String getHaveFrier() {
        return haveFrier;
    }

    public void setHaveFrier(String haveFrier) {
        this.haveFrier = haveFrier;
    }

    public Integer getNumberOfClaims() {
        return numberOfClaims;
    }

    public void setNumberOfClaims(Integer numberOfClaims) {
        this.numberOfClaims = numberOfClaims;
    }
}
