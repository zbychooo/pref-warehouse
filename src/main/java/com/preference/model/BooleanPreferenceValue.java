package com.preference.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BooleanPreferenceValue")
public class BooleanPreferenceValue extends PreferenceValue {

    @Column
    private Boolean value;

    public BooleanPreferenceValue() {
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
