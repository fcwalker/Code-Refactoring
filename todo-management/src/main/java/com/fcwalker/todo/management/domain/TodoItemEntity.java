package com.fcwalker.todo.management.domain;

import com.fcwalker.todo.management.enums.TodoStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 待办事项实体
 *
 * @author fcwalker
 * @date 2021/3/2 22:42
 **/
@AllArgsConstructor
@Getter
public class TodoItemEntity {
    /**
     * 唯一标识符
     */
    private String uuid;
    /**
     * 待办事项内容
     */
    private String context;
    /**
     * 待办事项状态
     */
    private TodoStatus status;

    public void completeTodoEntity() {
        this.status = TodoStatus.COMPLETED;
    }
}
