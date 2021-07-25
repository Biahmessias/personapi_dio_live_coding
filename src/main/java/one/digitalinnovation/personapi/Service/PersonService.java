package one.digitalinnovation.personapi.Service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.DTO.MessageResponseDTO;
import one.digitalinnovation.personapi.DTO.Request.PersonDTO;
import one.digitalinnovation.personapi.Entity.Person;
import one.digitalinnovation.personapi.Exception.PersonNotFoundException;
import one.digitalinnovation.personapi.Mapper.PersonMapper;
import one.digitalinnovation.personapi.Repository.PersonRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository repo;

    private PersonMapper mapper = Mappers.getMapper(PersonMapper.class);


    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = mapper.toModel(personDTO);
        Person savedPerson = repo.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created Person With ID " + savedPerson.getId())
                .build();
    }

    public void delete(Long id) throws PersonNotFoundException {
        repo.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        repo.deleteById(id);
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Optional<Person> optionalPerson= repo.findById(id);
        if(optionalPerson.isEmpty()) {
           throw new PersonNotFoundException(id);
        }
        return mapper.toDTO(optionalPerson.get());
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = this.repo.findAll();
        return allPeople.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        findById(id);

        Person personToUpdate = mapper.toModel(personDTO);
        Person savedPerson = repo.save(personToUpdate);
        return MessageResponseDTO
                .builder()
                .message("Updated Person With ID " + savedPerson.getId())
                .build();



    }
}




