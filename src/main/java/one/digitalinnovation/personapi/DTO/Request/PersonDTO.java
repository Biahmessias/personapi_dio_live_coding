package one.digitalinnovation.personapi.DTO.Request;


import lombok.*;
import one.digitalinnovation.personapi.Entity.Phone;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max= 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max= 100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    @NotNull
    private LocalDate birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;
}
