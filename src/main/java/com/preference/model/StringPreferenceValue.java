package com.preference.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class StringPreferenceValue extends PreferenceValue {
    @Column
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
