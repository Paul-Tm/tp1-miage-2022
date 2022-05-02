package com.acme.todolist.adapters.rest_api;

import com.acme.todolist.application.port.in.AddTodoItem;
import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.domain.TodoItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Equals;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class TodoListControllerTest {

    @Mock
    private  GetTodoItems getTodoItemsQuery;

    @Mock
    private  AddTodoItem addTodoItem;

    @InjectMocks
    private TodoListController controller;

    @Test
    void getAllTodoItemsTest(){
        //PREPARER
        TodoItem item= new TodoItem("1", Instant.now(),"test");
        Mockito.when(getTodoItemsQuery.getAllTodoItems()).thenReturn(Collections.singletonList(item));

        //EXECUTER
        List<TodoItem> result = controller.getAllTodoItems();

        //VERIFIER
        Assertions.assertEquals(1,result.size());
    };

    @Test
    void ajouterItemTest(){
        //PREPARER
        TodoItem item= new TodoItem("1", Instant.now(),"test");

        //EXECUTER
        controller.ajouterItem(item);

        //VERIFIER
        Mockito.verify(addTodoItem,Mockito.times(1)).addTodoItem(item);
    };



}