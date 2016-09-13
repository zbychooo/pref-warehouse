package com.preference.model;

import javax.persistence.*;

@Entity
public class Preference implements Preferenceable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "internal_name", nullable = false, unique = true)
    private String internalName;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "parent_id")
    private Long parentId;

    @Enumerated(EnumType.STRING)
    private ValueType valueType;

    @Column(length = 1000)
    private String value;

    public Preference() {
    }

    public Preference(String internalName, String displayName, Long parentId, ValueType valueType, String value) {
        this.internalName = internalName;
        this.displayName = displayName;
        this.parentId = parentId;
        this.valueType = valueType;
        this.value = value;
    }

    public Preference(Long id, String internalName, String displayName, Long parentId, ValueType valueType, String value) {
        this.id = id;
        this.internalName = internalName;
        this.displayName = displayName;
        this.parentId = parentId;
        this.valueType = valueType;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
