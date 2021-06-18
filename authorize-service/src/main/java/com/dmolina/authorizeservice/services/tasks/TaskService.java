package com.dmolina.authorizeservice.services.tasks;

import com.dmolina.authorizeservice.models.dto.tasks.CreateTaskDto;
import com.dmolina.authorizeservice.models.vo.tasks.Actions;
import com.dmolina.authorizeservice.models.vo.tasks.Person;
import com.dmolina.authorizeservice.models.vo.tasks.TaskEntity;
import com.dmolina.authorizeservice.models.vo.users.UserEntity;
import com.dmolina.authorizeservice.repository.tasks.ActionsRepository;
import com.dmolina.authorizeservice.repository.tasks.PersonRepository;
import com.dmolina.authorizeservice.repository.tasks.TaskRepository;
import com.dmolina.authorizeservice.repository.users.UserEntityRepository;
import com.dmolina.authorizeservice.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService extends BaseService<TaskEntity, Long, TaskRepository> {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private ActionsRepository actionsRepository;

    @Autowired
    private PersonRepository personRepository;

    public TaskEntity newTask(Long creatorId, CreateTaskDto taskDto) {
        Optional<UserEntity> userEntity = userEntityRepository.findById(creatorId);
        List<Actions> actions = actionsRepository.getActionsByIds(taskDto.getActions());
        Optional<Person> person =personRepository.findById(taskDto.getPersonId());
        if (!userEntity.isPresent()) {

        }
        if(CollectionUtils.isEmpty(actions)){

        }
        if (!person.isPresent()) {

        }

        TaskEntity taskEntity = TaskEntity.builder()
                .creatorId(userEntity.get())
                .actions(actions)
                .taskName(taskDto.getTaskName())
                .minutes(taskDto.getMinutes())
                .person(person.get())
                .build();

        return this.save(taskEntity);
    }

    public Page<TaskEntity> findAll(int numPage) {
        Pageable pageRequest = PageRequest.of(numPage - 1, 2, Sort.by("id"));
        return this.repositorio.findAll(pageRequest);
    }

    public Page<TaskEntity> findByCreator(String creatorID, int numPage) {
        Pageable pageRequest = PageRequest.of(numPage - 1, 2, Sort.by("id"));
        return this.repositorio.findByCreatorId(creatorID, pageRequest);
    }


}
