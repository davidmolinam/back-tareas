package com.dmolina.authorizeservice.repository.tasks;

import com.dmolina.authorizeservice.models.vo.tasks.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<TaskEntity, Long>, JpaRepository<TaskEntity, Long> {

    Page<TaskEntity> findByCreatorId(String creatorId, Pageable pageable);


}