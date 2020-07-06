package com.uibsoft.covid_info.Model;

public class ZoneModel {


    private String stateName;
    private String stateCase;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateCase() {
        return stateCase;
    }

    public void setStateCase(String stateCase) {
        this.stateCase = stateCase;
    }

    public ZoneModel(String stateName, String stateCase) {
        this.stateName = stateName;
        this.stateCase = stateCase;
    }
}
