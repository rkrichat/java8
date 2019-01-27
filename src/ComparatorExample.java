import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String... args){

        List<Integer> exampleData = Arrays.asList(9, 8, 4, 1, 7, 3);

        //Sorted min -> max
        System.out.println("Sort MIN -> MAX");
        orderValueInList(exampleData,Comparator.naturalOrder());

        //Sort max -> min
        System.out.println("Sort MAX -> MIN");
        orderValueInList(exampleData, Comparator.reverseOrder());

        List<Student> studentList = Arrays.asList(new Student("B",2), new Student("B",5), new Student("A",10));
        //Sort name of Student from less to grater than
        System.out.println("Sort Student's name MIN -> MAX");
        orderValueInList(studentList, Comparator.comparing(Student::getName));

        //Sort name of Student from grater to less than
        System.out.println("Sort Student's name MAX -> MIN");
        orderValueInList(studentList, Comparator.comparing(Student::getName).reversed());

        //Sort Student's name, in case Student has same name then sort age
        System.out.println("Sort Student's name MIN -> MAX, if student has same name then sorted by age");
        orderValueInList(studentList, Comparator.comparing(Student::getName).thenComparing(Student::getAge));


        //Sort Student's name, in case Student has same name then sort age
        System.out.println("Sort Student's name MIN -> MAX, if student has same name then sorted by age");
        Comparator<Student> sortAgeRevert = Comparator.comparing(Student::getAge).reversed();
        orderValueInList(studentList, Comparator.comparing(Student::getName).thenComparing(sortAgeRevert));

    }

    /**
     * This method for order value and this is generic method expected two parameter.
     * @param list
     * @param comparator
     * @param <T>
     */
    private static <T> void orderValueInList(List<T> list, Comparator<T> comparator) {
        list.stream().sorted(comparator).forEach(System.out::println);
        System.out.println("---------------------------------------------");
    }
}

class Student{
    private String name;
    private Integer age;

    public Student(){}

    public Student(String name, Integer age){this.name = name; this.age = age;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
