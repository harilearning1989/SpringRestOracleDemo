package com.example.demo.repos;

import com.example.demo.dto.RandomNumber;
import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IPersonRepository extends CrudRepository<Person, Long> {

    public static final String FIND_PROJECTS = "select a,b from TABLE (cast(get_number_upto() as myTable_type))";

    @Query(value = FIND_PROJECTS, nativeQuery = true)
    public List<Object[]> getNumberUptoNativeSql();

    @Procedure(name = Person.NamedQuery_MoveToHistory)
    String movePersonToHistory(@Param("person_id_in") long personId);

    @Procedure(name = Person.NamedQuery_FetchFromHistory)
    List<Person> fetchPersonHistory();

}
