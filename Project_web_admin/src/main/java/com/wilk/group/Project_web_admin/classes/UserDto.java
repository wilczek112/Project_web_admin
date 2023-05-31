package com.wilk.group.Project_web_admin.classes;


import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    @Size(min=3,max=32, message = "Login musi zawierać od 3 do 32 znaków.")
    private String login;
    @Pattern(regexp = "((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_-]).{6,64})", message = "Hasło musi składać się z dużych i małych liter, cyfr oraz znaklów specjalnych. Dopuszczalna długość to 6-64 znaków.")
    private String password;
    @NotBlank(message = "Pole nie może być puste")
    @Email(message = "Niepoprawny email")
    private String email;
}
