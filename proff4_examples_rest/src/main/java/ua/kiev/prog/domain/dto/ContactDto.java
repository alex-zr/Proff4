package ua.kiev.prog.domain.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal=false, level= AccessLevel.PRIVATE)
public class ContactDto {
    long id;
    String groupName;
    String name;
    String surname;
    String phone;
    String email;
}
