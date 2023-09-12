package com.machinesoftware.intelligentvampire.ui.dto;

import com.machinesoftware.intelligentvampire.domain.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO toDto(Task task);

    Task toEntity(TaskDTO dto);

    List<TaskDTO> toDTOList(List<Task> tasks);

    List<Task> toEntityList(List<TaskDTO> tasks);
}
