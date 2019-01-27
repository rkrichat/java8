import java.util.Optional;


/**
 * Optional has two option to define method
 *  1. Optional.of(T) -> away expect value of T, in case T is null system will throw NullPointerException.
 *  2. Optional.ofNullable(T) -> allow T to be null and will set empty if T is null.
 *      ps. In case ofNullable(T) and T is null, if we try to invoke optional.get() then system will throw NoSuchElementException.
 *      to avoid this Exception, should be check with ifPresent or use orElseThrow to throw some Exception or use orElseGet to create instance.
 *
 *      ifPresent -> invoke Consumer if T is not null
 *      orElseThrow -> throw Exception if T is null
 *      orElseGet(T::new) -> create instance to Object if T is null
 *
 */
public class OptionalExample {
    public static void main(String... args) {
        Teacher teacher = null;

        Optional<Teacher> optionalTeacher = Optional.ofNullable(teacher);

        //This will throw RuntimeException with message Test when teacher is null
        //Optional.ofNullable(teacher).orElseThrow(()->new RuntimeException("Test"));

        //System will throw NoSuchElementException When we try to get value and that value is null
        //System.out.println(optionalTeacher.get());

        //We can  use ifPresent to avoid checking null
        optionalTeacher.ifPresent(System.out::println); //-> do nothing because teacher is null

        //Will create instance if teacher is null
        teacher = Optional.ofNullable(teacher).orElseGet(Teacher::new);

        //Print Teacher if not null
        optionalTeacher.ifPresent(System.out::println);

    }
}

class Teacher{
    private String name;

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                '}';
    }

}
