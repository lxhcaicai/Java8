package org.example.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter
    @Setter
    private Integer id;

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PACKAGE)
    private String userName;

    private String password;

    private String phone;

    private String email;
}
