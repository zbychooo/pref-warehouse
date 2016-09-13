package com.preference.repository;

import com.preference.model.Preference;
import com.preference.model.ValueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {

    @Query("Update Preference p SET p.internalName= :internal_name, p.displayName = :display_name, p.parentId= :parent_id, p.valueType = :valueType, p.value = :value WHERE p.id = :id")
    void updatePreference(@Param("id") Long id, @Param("internal_name") String internalName,
                          @Param("display_name") String displayName, @Param("parent_id") Long parentId, @Param("valueType") ValueType valueType, @Param("value") String value);

    @Query("SELECT p FROM Preference p WHERE p.parentId= :parentId")
    List<Preference> findAllByParentId(@Param("parentId") Long parentId);
}
