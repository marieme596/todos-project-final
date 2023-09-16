package sn.ept.git.seminaire.cicd.mappers;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sn.ept.git.seminaire.cicd.dto.TagDTO;
import sn.ept.git.seminaire.cicd.dto.TagDTO.TagDTOBuilder;
import sn.ept.git.seminaire.cicd.dto.TodoDTO;
import sn.ept.git.seminaire.cicd.dto.TodoDTO.TodoDTOBuilder;
import sn.ept.git.seminaire.cicd.models.Tag;
import sn.ept.git.seminaire.cicd.models.Tag.TagBuilder;
import sn.ept.git.seminaire.cicd.models.Todo;
import sn.ept.git.seminaire.cicd.models.Todo.TodoBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-15T17:54:07+0000",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class TodoMapperImpl implements TodoMapper {

    @Override
    public Todo asEntity(TodoDTO d) {
        if ( d == null ) {
            return null;
        }

        TodoBuilder<?, ?> todo = Todo.builder();

        todo.id( d.getId() );
        todo.createdDate( d.getCreatedDate() );
        todo.lastModifiedDate( d.getLastModifiedDate() );
        todo.version( d.getVersion() );
        todo.enabled( d.isEnabled() );
        todo.deleted( d.isDeleted() );
        todo.title( d.getTitle() );
        todo.description( d.getDescription() );
        todo.completed( d.isCompleted() );
        todo.tags( tagDTOSetToTagSet( d.getTags() ) );

        return todo.build();
    }

    @Override
    public TodoDTO asDTO(Todo e) {
        if ( e == null ) {
            return null;
        }

        TodoDTOBuilder<?, ?> todoDTO = TodoDTO.builder();

        todoDTO.id( e.getId() );
        todoDTO.createdDate( e.getCreatedDate() );
        todoDTO.lastModifiedDate( e.getLastModifiedDate() );
        todoDTO.version( e.getVersion() );
        todoDTO.enabled( e.isEnabled() );
        todoDTO.deleted( e.isDeleted() );
        todoDTO.title( e.getTitle() );
        todoDTO.description( e.getDescription() );
        todoDTO.completed( e.isCompleted() );
        todoDTO.tags( tagSetToTagDTOSet( e.getTags() ) );

        return todoDTO.build();
    }

    protected Tag tagDTOToTag(TagDTO tagDTO) {
        if ( tagDTO == null ) {
            return null;
        }

        TagBuilder<?, ?> tag = Tag.builder();

        tag.id( tagDTO.getId() );
        tag.createdDate( tagDTO.getCreatedDate() );
        tag.lastModifiedDate( tagDTO.getLastModifiedDate() );
        tag.version( tagDTO.getVersion() );
        tag.enabled( tagDTO.isEnabled() );
        tag.deleted( tagDTO.isDeleted() );
        tag.name( tagDTO.getName() );
        tag.description( tagDTO.getDescription() );

        return tag.build();
    }

    protected Set<Tag> tagDTOSetToTagSet(Set<TagDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Tag> set1 = new HashSet<Tag>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TagDTO tagDTO : set ) {
            set1.add( tagDTOToTag( tagDTO ) );
        }

        return set1;
    }

    protected TagDTO tagToTagDTO(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagDTOBuilder<?, ?> tagDTO = TagDTO.builder();

        tagDTO.id( tag.getId() );
        tagDTO.createdDate( tag.getCreatedDate() );
        tagDTO.lastModifiedDate( tag.getLastModifiedDate() );
        tagDTO.version( tag.getVersion() );
        tagDTO.enabled( tag.isEnabled() );
        tagDTO.deleted( tag.isDeleted() );
        tagDTO.name( tag.getName() );
        tagDTO.description( tag.getDescription() );

        return tagDTO.build();
    }

    protected Set<TagDTO> tagSetToTagDTOSet(Set<Tag> set) {
        if ( set == null ) {
            return null;
        }

        Set<TagDTO> set1 = new HashSet<TagDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Tag tag : set ) {
            set1.add( tagToTagDTO( tag ) );
        }

        return set1;
    }
}
