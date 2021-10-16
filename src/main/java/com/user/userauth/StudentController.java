package com.user.userauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //GET method
    //http://localhost:8080/hello-world

    @GetMapping("/student")
    public Student getStudent(){
        return new Student("Naman", "Verma");
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Rahul", "Verma"));
        students.add(new Student("Ramesh", "Verma"));
        students.add(new Student("Kunal", "Verma"));
        students.add(new Student("Udayan", "Verma"));
        students.add(new Student("Rajat", "Verma"));
        return students;
    }

    // http://localhost:8080/student/ramesh/verma
    // @PathVariable annotation
    @GetMapping("/student/{firstName}/{lastName}/")
    public Student getUsingPathVariables(@PathVariable("firstName") String fName, @PathVariable("lastName") String lName){
        return new Student(fName, lName);
    }

    // build rest api to handle query parameters
    // http://localhost:8080/student?firstName=naman&lastName=verma
    @GetMapping("/student/query")
    public Student getUsingParams(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName ){
        return new Student(firstName, lastName);
    }
}
