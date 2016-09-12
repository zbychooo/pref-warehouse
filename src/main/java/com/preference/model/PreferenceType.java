package com.preference.model;

public enum PreferenceType {

    STRING(StringPreferenceValue.class.getName()),
    NUMBER(NumberPreferenceValue.class.getName()),
    BOOLEAN(BooleanPreferenceValue.class.getName());

    String name;

    PreferenceType(String name) {
        this.name = name;
    }
}
