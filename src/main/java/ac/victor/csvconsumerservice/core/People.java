package ac.victor.csvconsumerservice.core;

import java.util.ArrayList;

public class People {
    ArrayList<Person> personList;

    public People() {
        personList = new ArrayList<Person>();
    }

    private void addPerson(Person additionalPerson) {
        personList.add(additionalPerson);
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
}
