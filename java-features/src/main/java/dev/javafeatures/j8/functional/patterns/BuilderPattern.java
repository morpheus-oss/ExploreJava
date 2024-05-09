package dev.javafeatures.j8.functional.patterns;

import java.util.function.Consumer;

class Person    {
    private String firstName;
    private String lastName;

    Person(String firstName, String lastName)   {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}

class PersonBuilder {
    String firstName;
    String lastName;

    PersonBuilder with(Consumer<PersonBuilder> builderFunction)     {
        builderFunction.accept(this);
        return this;
    }

    Person build()  {
        return new Person(firstName, lastName);
    }
}

public class BuilderPattern {

    public static void main(String[] args)  {
        Person person = new PersonBuilder().with(fn -> fn.firstName = "James")
                                           .with(fn -> fn.lastName = "Gosling")
                                           .build();
        System.out.println("Person:: First Name:" + person.getFirstName()
                                + ", Last Name:" + person.getLastName());
    }
}
