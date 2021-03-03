package com.fcwalker.todo.management.repository;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import com.alibaba.fastjson.JSON;
import com.fcwalker.todo.management.domain.TodoItemEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fcwalker
 * @date 2021/3/3 21:46
 **/
@Repository("fileTodoItemRepository")
public class FileTodoItemRepository implements TodoItemRepository {
    private final String undo_file_path = "./undo.txt";
    private final String completed_file_path = "./completed.txt";

    @Override
    public void saveTodoItem(final TodoItemEntity entity) {
        FileWriter writer = new FileWriter(undo_file_path);
        String json = JSON.toJSONString(entity);
        writer.append(json + "\n");
    }

    @Override
    public void completeTodoItem(final TodoItemEntity entity) {
        FileWriter writer = new FileWriter(completed_file_path);
        entity.completeTodoEntity();
        String json = JSON.toJSONString(entity);
        clearUndoItemFromUndoList(entity.getUuid());
        writer.append(json + "\n");
    }

    private synchronized void clearUndoItemFromUndoList(final String uuid) {
        List<TodoItemEntity> undoItems = queryFromTxt(undo_file_path);
        undoItems = undoItems.stream().filter(undoItem -> !undoItem.getUuid().equals(uuid)).collect(Collectors.toList());
        FileWriter writer = new FileWriter(undo_file_path);
        writer.write("");
        undoItems.forEach(undoItem -> writer.append(JSON.toJSONString(undoItem) + "\n"));
    }

    @Override
    public List<TodoItemEntity> queryUndoList() {
        List<TodoItemEntity> undolists = new ArrayList<>();
        undolists.addAll(queryFromTxt(undo_file_path));
        return undolists;
    }

    @Override
    public List<TodoItemEntity> queryAllList() {
        List<TodoItemEntity> items = new ArrayList<>();
        items.addAll(queryFromTxt(undo_file_path));
        items.addAll(queryFromTxt(completed_file_path));
        return items;
    }

    private List<TodoItemEntity> queryFromTxt(String path) {
        FileReader fileReader = new FileReader(path);
        List<String> jsons = fileReader.readLines();
        List<TodoItemEntity> lists = new ArrayList<>();
        jsons.forEach(json -> lists.add(JSON.parseObject(json, TodoItemEntity.class)));
        return lists;
    }
}
