package fajar.belajar.JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JacksonAnnotationTest {


    /** Jackson Annotation
     * Jackson secara default akan membuat JSON dari Java Class, dari membaca field yang ada, sampai membuat attribute di JSON nya
     * Jackson menyediakan beberapa annotation yang bisa kita gunakan untuk mengubah behaviour default dari Jackson dengan cara menambahkan Jackson Annotation pada class Java nya
     * https://fasterxml.github.io/jackson-annotations/javadoc/2.7/com/fasterxml/jackson/annotation/package-summary.html
     */


    @Test
    @SneakyThrows
    void testAnnotation() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Student student = new Student();
        student.setFirstName("fajar abdillah");
        student.setLastName(" ahmad");
        student.setFullname(student.getFirstName()+student.getLastName());
        student.setPassword("rahasia123");
        student.setGrade(3);
        student.setCreatedAt(new Date());
        student.setUpdateAt(new Date());


        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .setDateFormat(simpleDateFormat);//simple date untuk menampilkan pattern yang telah kita buat pada json
        String value = objectMapper.writeValueAsString(student);

        System.out.println(value);
    }
}
