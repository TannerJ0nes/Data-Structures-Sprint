package com.keyin.sprint.repository;

import com.keyin.sprint.entity.TreeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeDataRepository extends JpaRepository<TreeData, Long> {


    @Query("SELECT td FROM TreeData td WHERE td.inputNumbers LIKE %?1%")
    List<TreeData> findByNumberInInput(String number);

    List<TreeData> findAllByOrderByIdDesc();
}
