package sn.ept.git.seminaire.cicd.services.impl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sn.ept.git.seminaire.cicd.dto.TodoDTO;
import sn.ept.git.seminaire.cicd.exceptions.ItemNotFoundException;
import sn.ept.git.seminaire.cicd.mappers.TodoMapper;
import sn.ept.git.seminaire.cicd.mappers.vm.TodoVMMapper;
import sn.ept.git.seminaire.cicd.models.Todo;
import sn.ept.git.seminaire.cicd.repositories.TodoRepository;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class TodoServiceImplTest {

    private TodoServiceImpl todoService;

    @Mock
    private TodoRepository repository;

    @Mock
    private TodoMapper mapper;

    @Mock
    private TodoVMMapper vmMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        todoService = new TodoServiceImpl(repository, mapper, vmMapper);
    }

    @Test
    void completeTodoWithValidIdShouldSetCompletedToTrue() {
        // Arrange
        UUID todoId = UUID.randomUUID();
        Todo todo = new Todo();
        TodoDTO todoCompleted = new TodoDTO();
        todo.setId(todoId);
        when(repository.findById(todoId)).thenReturn(Optional.of(todo));
        when(repository.saveAndFlush(todo)).thenReturn(todo);

        // Act
        todoCompleted = todoService.complete(todoId);

        // Assert
        verify(repository, times(1)).findById(todoId);
        verify(repository, times(2)).saveAndFlush(todo);
        assert(todo.isCompleted());
    }

    @Test
    void completeTodoWithInvalidIdShouldThrowItemNotFoundException() {
        // Arrange
        UUID todoId = UUID.randomUUID();
        when(repository.findById(todoId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ItemNotFoundException.class, () -> {
            todoService.complete(todoId);
        });
        verify(repository, times(1)).findById(todoId);
        verify(repository, never()).saveAndFlush(any());
    }
}
