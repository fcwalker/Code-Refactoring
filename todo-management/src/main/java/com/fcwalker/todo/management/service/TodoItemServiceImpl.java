package com.fcwalker.todo.management.service;

import com.fcwalker.todo.management.domain.TodoItemEntity;
import com.fcwalker.todo.management.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fcwalker
 * @date 2021/3/2 23:46
 **/
@Service("todoItemService")
public class TodoItemServiceImpl implements TodoItemService {
    @Autowired
    @Qualifier("fileTodoItemRepository")
    private TodoItemRepository todoItemRepository;

    @Override
    public void saveItem(TodoItemEntity entity) {
        todoItemRepository.saveTodoItem(entity);
    }

    @Override
    public void completeItem(TodoItemEntity entity) {
        todoItemRepository.completeTodoItem(entity);
    }

    @Override
    public List<TodoItemEntity> queryUndos() {
        return todoItemRepository.queryUndoList();
    }
}
