package sn.ept.git.seminaire.cicd.mapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import sn.ept.git.seminaire.cicd.data.TagVMTestData;
import sn.ept.git.seminaire.cicd.dto.vm.TagVM;
import sn.ept.git.seminaire.cicd.mappers.vm.TagVMMapper;
import sn.ept.git.seminaire.cicd.models.Tag;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TagVMMapperTest {

    static TagVM vm;
    static Tag entity;

    private TagVMMapper mapper  =  Mappers.getMapper(TagVMMapper.class);

    @BeforeAll
    static void beforeAll() {
        vm = TagVMTestData.defaultVM();
    }

    @Test
    void toEntityShouldReturnCorrectEntity() {
        entity = mapper.asEntity(vm);
        assertThat(entity)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringActualNullFields()
                .isEqualTo(vm);
    }

    @Test
    void toDTOShouldReturnCorrectDTO() {
        vm = mapper.asDTO( mapper.asEntity(vm));
        assertThat(vm)
                .isNotNull()
                .hasNoNullFieldsOrProperties()
                .usingRecursiveComparison()
                .isEqualTo(entity);
    }
    @Test
    void toEntityListShouldReturnCorrectEntityList() {
        // Créez une liste de TagVM
        List<TagVM> vmList = new ArrayList<>();
        vmList.add(vm);

        // Utilisez le mapper pour mapper la liste de TagVM vers une liste de Tag
        List<Tag> entityList = mapper.asEntityList(vmList);

        // Assertions pour vérifier que la conversion a réussi
        assertThat(entityList)
                .isNotNull()
                .hasSize(vmList.size());

    }

    @Test
    void toDTOListShouldReturnCorrectDTOList() {
        // Créez une liste de Tag
        List<Tag> entityList = new ArrayList<>();
        entityList.add(entity);

        // Utilisez le mapper pour mapper la liste de Tag vers une liste de TagVM
        List<TagVM> vmList = mapper.asDTOList(entityList);

        // Assertions pour vérifier que la conversion a réussi
        assertThat(vmList)
                .isNotNull()
                .hasSize(entityList.size());
    }

}