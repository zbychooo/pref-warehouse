package com.preference.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NumberPreferenceValue")
public class NumberPreferenceValue extends PreferenceValue {

    @Column
    private Number value;

    public NumberPreferenceValue() {
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }
}
