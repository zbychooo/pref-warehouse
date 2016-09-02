package com.preference.repository;

import com.preference.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT * FROM PreferenceCategory WHERE parent_id=null")
    Category getRoot();

    @Query("Update PreferenceCategory pc SET pc.internal_name= :internal_name, pc.display_name =: display_name, pc.parent_id= :parent_id WHERE pc.id = :id")
    Category updateCategory(@Param("id") Long id, @Param("internal_name") String internalName,
                            @Param("display_name") String displayName, @Param("parent_id") Long parentId);
}
