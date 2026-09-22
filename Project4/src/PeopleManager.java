import java.util.ArrayList;
import java.util.List;

public class PeopleManager {

    private List<Person> peopleList;

    // construtor
    public PeopleManager(){
        this.peopleList = new ArrayList<>();
    }

    // método para retornar a lista de pessoas
    public List<Person> getPeopleList(){
        return peopleList;
    }

    // método para adicionar/salvar uma pessoa na lista
    public boolean save(Person person){
        if(person != null){
            peopleList.add(person);
            return true;
        }
        return false;
    }

    public Person search(String cpf){
        for(Person person : peopleList){
            if(person.getCpf().equals(cpf)){
                return person;
            }
        }
        return null;
    }

    public boolean update(String name, String cpf){
        Person person = search(cpf);
        if(person != null){
            int index = peopleList.indexOf(person);
            if(index != -1){
                person.setName(name);
                peopleList.set(index, person);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String cpf){
        Person person = search(cpf);
        if(person != null){
            peopleList.remove(person);
            return true;
        }
        return false;
    }

}
