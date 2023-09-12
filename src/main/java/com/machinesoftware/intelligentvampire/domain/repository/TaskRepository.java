package com.machinesoftware.intelligentvampire.domain.repository;

import com.machinesoftware.intelligentvampire.domain.model.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Transactional
    @Procedure(name = "CREATE_TASK")
    void CREATE_TASK(@Param("NAME") String name, @Param("DESCRIPTION") String description);

    @Transactional
    @Procedure(name = "SEL_ALL")
    List<Task> SEL_ALL();

    @Transactional
    @Procedure(name = "UPDATE_TASK")
    void UPDATE_TASK(@Param("NAME") String name, @Param("DESCRIPTION") String description, @Param("ID") Integer id);

    @Transactional
    @Procedure(name = "DELETE_TASK")
    void DELETE_TASK(@Param("ID") Integer id);

    @Transactional
    @Procedure(name = "SEL_BY_ID")
    Task SEL_BY_ID(@Param("ID") Integer id);

    @Transactional
    @Procedure(name = "COMPLETED")
    void COMPLETED(Integer id);


}
