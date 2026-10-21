package harker.techtest;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person {

    @Id
    public String id;

    public String fullName;
    public String email;

}
