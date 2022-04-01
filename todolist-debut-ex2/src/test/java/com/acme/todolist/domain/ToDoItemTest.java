package com.acme.todolist.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import java.sql.Time;
import java.time.Instant;
import java.time.temporal.ChronoUnit;


public class ToDoItemTest {

    @Test
    public void isLateTrueTest(){
        //Preparer
        TodoItem todoItem = new TodoItem("test", Instant.now().minus(10, ChronoUnit.DAYS),"test");

        //VERIFIER
        Assertions.assertTrue(todoItem.isLate());
    }

    @Test
    void isLateFalseTest(){
        //Preparer
        TodoItem todoItem = new TodoItem("test", Instant.now().plus(10, ChronoUnit.DAYS),"test");

        //VERIFIER
        Assertions.assertFalse(todoItem.isLate());
    }

}
