package com.preference.model;

import javax.persistence.*;

@Entity
@Table(name = " PreferenceCategory")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "internal_name", nullable = false, unique = true)
    private String internalName;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "parent_id")
    private Long parentId;

    public Category() {
    }

    public Category(Long id, String displayName, String internalName, Long parentId) {
        this.displayName = displayName;
        this.id = id;
        this.internalName = internalName;
        this.parentId = parentId;
    }

    public Category(String internalName, String displayName, Long parentId) {
        this.internalName = internalName;
        this.parentId = parentId;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Category{");
        sb.append("displayName='").append(displayName).append('\'');
        sb.append(", id=").append(id);
        sb.append(", internalName='").append(internalName).append('\'');
        sb.append(", parentId=").append(parentId);
        sb.append('}');
        return sb.toString();
    }
}
