package org.pg.eureka.server.clients.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.pg.eureka.server.clients.utils.enums.EGender;
import org.pg.eureka.server.clients.utils.enums.ENationality;
import org.pg.eureka.server.clients.utils.enums.ESeries;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

import static org.pg.eureka.server.clients.utils.constants.DtoValidatorConstants.*;

@Data
@Builder
public class ClientDto implements Serializable {
    @NotBlank(message = "Last Name is mandatory!")
    @Pattern(regexp = NAME_VALIDATION_REJEX, message = "Last Name not valid!")
    private String lastName;

    @NotBlank(message = "First Name is mandatory!")
    @Pattern(regexp = NAME_VALIDATION_REJEX, message = "First Name not valid!")
    private String firstName;

    @NotNull(message = "Gender is mandatory!")
    private EGender gender;

    @NotBlank(message = "CNP is mandatory!")
    @Length(min = 13, max = 13, message = "CNP always has 13 digits!")
    @Pattern(regexp = DIGITS_VALIDATION_REJEX, message = "CNP can contain only digits!")
    private String cnp;

    @NotNull(message = "Identity card series is mandatory!")
    private ESeries series;

    @NotBlank(message = "Identity card number is mandatory!")
    @Length(min = 6, max = 6, message = "Identity card number always contains 6 digits!")
    @Pattern(regexp = DIGITS_VALIDATION_REJEX, message = "Identity card number can contain only digits!")
    private String number;

    @NotNull(message = "Nationality is mandatory!")
    private ENationality nationality;

    @NotBlank(message = "Birth place is mandatory!")
    @Pattern(regexp = ADDRESS_VALIDATION_REJEX, message = "Birth Place not valid!")
    private String birthPlace;

    @NotBlank(message = "Address is mandatory!")
    @Pattern(regexp = ADDRESS_VALIDATION_REJEX, message = "Address not valid!")
    private String address;

    @NotBlank(message = "Issuer field is mandatory!")
    @Pattern(regexp = NAME_VALIDATION_REJEX, message = "Issuer is not valid not valid!")
    private String issuer;

    @NotNull(message = "Issued on date is mandatory!")
    @PastOrPresent(message = "Issued on date must be in the past!")
    private LocalDate validFrom;

    @NotNull(message = "ExpireDate is mandatory!")
    @FutureOrPresent(message = "Expire date must be in the future!")
    private LocalDate validUntil;
}
