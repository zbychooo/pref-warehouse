package com.preference.model;

import javax.persistence.*;

@Entity
@Inheritance
public abstract class PreferenceValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long preferenceDefinitionId;

    public Long getPreferenceDefinitionId() {
        return preferenceDefinitionId;
    }

    public void setPreferenceDefinitionId(Long preferenceDefinitionId) {
        this.preferenceDefinitionId = preferenceDefinitionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
