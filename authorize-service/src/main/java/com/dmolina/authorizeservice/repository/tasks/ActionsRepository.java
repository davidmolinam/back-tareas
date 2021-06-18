package com.dmolina.authorizeservice.repository.tasks;

import com.dmolina.authorizeservice.models.vo.tasks.Actions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public interface ActionsRepository extends JpaRepository<Actions, Long> {

    @Query("select a from Actions a where a.id in (:actionIds)")
    List<Actions> getActionsByIds(@Param("actionIds") List<Long> ids);
}
