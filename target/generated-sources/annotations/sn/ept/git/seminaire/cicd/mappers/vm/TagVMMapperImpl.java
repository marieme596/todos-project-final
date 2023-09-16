package sn.ept.git.seminaire.cicd.mappers.vm;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sn.ept.git.seminaire.cicd.dto.vm.TagVM;
import sn.ept.git.seminaire.cicd.dto.vm.TagVM.TagVMBuilder;
import sn.ept.git.seminaire.cicd.models.Tag;
import sn.ept.git.seminaire.cicd.models.Tag.TagBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-15T17:54:07+0000",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class TagVMMapperImpl implements TagVMMapper {

    @Override
    public Tag asEntity(TagVM d) {
        if ( d == null ) {
            return null;
        }

        TagBuilder<?, ?> tag = Tag.builder();

        tag.id( d.getId() );
        tag.createdDate( d.getCreatedDate() );
        tag.lastModifiedDate( d.getLastModifiedDate() );
        tag.version( d.getVersion() );
        tag.enabled( d.isEnabled() );
        tag.deleted( d.isDeleted() );
        tag.name( d.getName() );
        tag.description( d.getDescription() );

        return tag.build();
    }

    @Override
    public TagVM asDTO(Tag e) {
        if ( e == null ) {
            return null;
        }

        TagVMBuilder<?, ?> tagVM = TagVM.builder();

        tagVM.id( e.getId() );
        tagVM.createdDate( e.getCreatedDate() );
        tagVM.lastModifiedDate( e.getLastModifiedDate() );
        tagVM.version( e.getVersion() );
        tagVM.enabled( e.isEnabled() );
        tagVM.deleted( e.isDeleted() );
        tagVM.name( e.getName() );
        tagVM.description( e.getDescription() );

        return tagVM.build();
    }
}
