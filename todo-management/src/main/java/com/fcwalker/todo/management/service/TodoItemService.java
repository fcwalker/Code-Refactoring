package com.fcwalker.todo.management.service;

import com.fcwalker.todo.management.domain.TodoItemEntity;

import java.util.List;

/**
 * @author fcwalker
 * @date 2021/3/2 23:45
 **/
public interface TodoItemService {

    /**
     * 保存待办清单
     * @param entity
     */
    void saveItem(TodoItemEntity entity);

    /**
     * 完成待办事项
     * @param entity
     */
    void completeItem(TodoItemEntity entity);

    List<TodoItemEntity> queryUndos();
}
