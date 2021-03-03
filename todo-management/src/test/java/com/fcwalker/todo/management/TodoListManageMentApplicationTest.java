package com.fcwalker.todo.management;

import cn.hutool.core.lang.UUID;
import com.fcwalker.todo.management.domain.TodoItemEntity;
import com.fcwalker.todo.management.enums.TodoStatus;
import com.fcwalker.todo.management.service.TodoItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TodoListManageMentApplication.class)
public class TodoListManageMentApplicationTest {
    @Autowired
    TodoItemService itemService;

    @Test
    public void saveItems() {
        for (int i = 0; i < 5; i++) {
            saveItem(i);
        }
    }

    public void saveItem(int id) {
        String uuid = UUID.randomUUID().toString();
        TodoItemEntity entity = new TodoItemEntity(uuid, "待办事项_"+id, TodoStatus.UNDO);
        itemService.saveItem(entity);
    }

    @Test
    public void completeItem() {
        List<TodoItemEntity> undos = itemService.queryUndos();
        TodoItemEntity item = undos.get(0);
        itemService.completeItem(item);
    }
}
