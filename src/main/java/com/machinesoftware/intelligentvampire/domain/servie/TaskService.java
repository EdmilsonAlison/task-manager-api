package com.machinesoftware.intelligentvampire.domain.servie;

import com.machinesoftware.intelligentvampire.domain.model.Task;
import com.machinesoftware.intelligentvampire.domain.repository.TaskRepository;
import com.machinesoftware.intelligentvampire.ui.dto.TaskDTO;
import com.machinesoftware.intelligentvampire.ui.dto.TaskMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {


    @Autowired
    private TaskRepository repository;

    @Autowired
    private TaskMapper mapper;

    @Transactional
    public Task create(TaskDTO taskDTO) {
        Task task = mapper.toEntity(taskDTO);
        repository.CREATE_TASK(task.getName(), task.getDescription());
        return task;
    }

    @Transactional
    public List<TaskDTO> findAll() {
        List<Task> tasks = repository.SEL_ALL();
        return mapper.toDTOList(tasks);
    }

    @Transactional
    public TaskDTO findById(Integer id) {
        return mapper.toDto(repository.SEL_BY_ID(id));
    }

    @Transactional
    public TaskDTO update(Integer id, TaskDTO task) {
        repository.UPDATE_TASK(task.getName(), task.getDescription(), id);
        return task;
    }

    @Transactional
    public void delete(Integer id) {
        repository.DELETE_TASK(id);
    }

    @Transactional
    public Boolean completed(Integer id) {
        if (Boolean.FALSE.equals(existsById(id))) {
            repository.COMPLETED(id);
            return true;
        }
        return false;
    }


    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    public TaskDTO toDTO(Task task) {
        return mapper.toDto(task);
    }
}
