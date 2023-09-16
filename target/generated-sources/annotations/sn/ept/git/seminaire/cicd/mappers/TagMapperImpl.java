package sn.ept.git.seminaire.cicd.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sn.ept.git.seminaire.cicd.dto.TagDTO;
import sn.ept.git.seminaire.cicd.dto.TagDTO.TagDTOBuilder;
import sn.ept.git.seminaire.cicd.models.Tag;
import sn.ept.git.seminaire.cicd.models.Tag.TagBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-15T17:54:08+0000",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag asEntity(TagDTO d) {
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
    public TagDTO asDTO(Tag e) {
        if ( e == null ) {
            return null;
        }

        TagDTOBuilder<?, ?> tagDTO = TagDTO.builder();

        tagDTO.id( e.getId() );
        tagDTO.createdDate( e.getCreatedDate() );
        tagDTO.lastModifiedDate( e.getLastModifiedDate() );
        tagDTO.version( e.getVersion() );
        tagDTO.enabled( e.isEnabled() );
        tagDTO.deleted( e.isDeleted() );
        tagDTO.name( e.getName() );
        tagDTO.description( e.getDescription() );

        return tagDTO.build();
    }
}
