package org.personal.app.pwdgen.domain;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "ucid_x_name_unq", columnNames = {"ucid", "name"})
})
@Entity
class PasswordEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Long ucid;

    @Column(nullable = false)
    private Boolean hasLowerCase,
                    hasUpperCase,
                    hasNumbers,
                    hasSpecialChars;

    private Integer length;
}