package com.fcwalker.todo.management.repository;

import com.fcwalker.todo.management.domain.TodoItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fcwalker
 * @date 2021/3/3 21:25
 **/
public interface TodoItemRepository {
    /**
     * 建立待办事项
     *
     * @param entity 待办事项实体
     */
    void saveTodoItem(final TodoItemEntity entity);

    /**
     * 完成待办事项
     *
     * @param entity 待办事项实体
     */
    void completeTodoItem(final TodoItemEntity entity);

    /**
     * 获取所有未完成的待办事项
     * @return List<TodoItemEntity>
     */
    List<TodoItemEntity> queryUndoList();

    /**
     * 获取所有的待办事项
     * @return List<TodoItemEntity>
     */
    List<TodoItemEntity> queryAllList();
}
