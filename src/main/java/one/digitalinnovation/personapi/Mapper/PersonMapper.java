package one.digitalinnovation.personapi.Mapper;

import one.digitalinnovation.personapi.DTO.Request.PersonDTO;
import one.digitalinnovation.personapi.Entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}
