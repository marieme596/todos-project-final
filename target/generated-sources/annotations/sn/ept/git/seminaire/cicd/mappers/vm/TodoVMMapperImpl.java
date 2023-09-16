package sn.ept.git.seminaire.cicd.mappers.vm;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sn.ept.git.seminaire.cicd.dto.vm.TodoVM;
import sn.ept.git.seminaire.cicd.dto.vm.TodoVM.TodoVMBuilder;
import sn.ept.git.seminaire.cicd.models.Todo;
import sn.ept.git.seminaire.cicd.models.Todo.TodoBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-15T17:54:07+0000",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class TodoVMMapperImpl implements TodoVMMapper {

    @Override
    public Todo asEntity(TodoVM vm) {
        if ( vm == null ) {
            return null;
        }

        TodoBuilder<?, ?> todo = Todo.builder();

        todo.tags( TodoVMMapper.asEntityQualifier( vm.getTags() ) );
        todo.id( vm.getId() );
        todo.createdDate( vm.getCreatedDate() );
        todo.lastModifiedDate( vm.getLastModifiedDate() );
        todo.version( vm.getVersion() );
        todo.enabled( vm.isEnabled() );
        todo.deleted( vm.isDeleted() );
        todo.title( vm.getTitle() );
        todo.description( vm.getDescription() );
        todo.completed( vm.isCompleted() );

        return todo.build();
    }

    @Override
    public TodoVM asDTO(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        TodoVMBuilder<?, ?> todoVM = TodoVM.builder();

        todoVM.tags( TodoVMMapper.asDTOQualifier( todo.getTags() ) );
        todoVM.id( todo.getId() );
        todoVM.createdDate( todo.getCreatedDate() );
        todoVM.lastModifiedDate( todo.getLastModifiedDate() );
        todoVM.version( todo.getVersion() );
        todoVM.enabled( todo.isEnabled() );
        todoVM.deleted( todo.isDeleted() );
        todoVM.title( todo.getTitle() );
        todoVM.description( todo.getDescription() );
        todoVM.completed( todo.isCompleted() );

        return todoVM.build();
    }
}
