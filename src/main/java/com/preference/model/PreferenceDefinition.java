package com.preference.model;

import javax.persistence.*;

@Entity
public class PreferenceDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "internal_name", nullable = false, unique = true)
    private String internalName;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PreferenceType preferenceType;

    //????
//    private PreferenceValue preferenceValue;


    public PreferenceDefinition() {
    }
}
