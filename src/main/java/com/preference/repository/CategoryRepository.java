package com.preference.repository;

import com.preference.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // name is taken from class, not from table...
    @Query(value = "SELECT c FROM Category c WHERE c.id=null")
    Category findRoot();

    @Query("Update Category c SET c.internalName= :internal_name, c.displayName = :display_name, c.parentId= :parent_id WHERE c.id = :id")
    void updateCategory(@Param("id") Long id, @Param("internal_name") String internalName,
                        @Param("display_name") String displayName, @Param("parent_id") Long parentId);

    @Query("SELECT c FROM Category c WHERE c.parentId= :parentId")
    List<Category> findAllByParentId(@Param("parentId") Long parentId);
}
