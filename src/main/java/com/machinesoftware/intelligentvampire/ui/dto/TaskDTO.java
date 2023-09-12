package com.machinesoftware.intelligentvampire.ui.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {
    private Integer id;
    private String name;
    private String description;
    private Boolean completed;

    public TaskDTO() {
        this.completed = false;
    }
}
