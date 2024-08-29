package fajar.belajar.JSON;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FeatureJsonTest {


    /** Mapper Feature
     * Saat kita membuat object dari class ObjectMapper, terdapat konfigurasi yang bisa kita lakukan pada ObjectMapper tersebut
     * Kita bisa melihat daftar konfigurasi yang tersedia di ObjectMapper di halaman :
     * https://github.com/FasterXML/jackson-databind/wiki/Mapper-Features
     */

    @Test
    @SneakyThrows
    void testFeatureJson() {

        ObjectMapper mapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);//KEY, VALUE untuk mengaktifkan salah satu feature jackson
//
        //penulisan object field firstNAME harus sama pada class objectnya, jika pada object firstName, maka ini akan error karna berbeda, pada json kita bisa mengaktifkan beberap feature
        String json = """
                {"firstNAME" : "fajar abdillah", "LASTname" : "ahmad", "grade" : 1}
                
                """;
        Student student = mapper.readValue(json, Student.class);
        Assertions.assertEquals("fajar abdillah", student.getFirstName());
        Assertions.assertEquals("ahmad", student.getLastName());
    }


    @Test
    @SneakyThrows
    void testSerializationFeature() {
        Student student = new Student();
        student.setFirstName("fajar abdillah");
        student.setLastName("ahmad");
        student.setGrade(3);


        Address address = new Address();
        address.setStreet("Radar Selatan");
        address.setCity("Pondok Gede");
        address.setCountry("indonesia");

        //masih banyak fitur serialization lainnya


        /** Serialization Feature
         * Jackson memiliki fitur yang bisa di aktifkan atau di nonaktifkan untuk proses serialization (menulis Java Object menjadi JSON)
         * Ada banyak sekali fitur yang terdapat di Jackson Serialization, kita bisa lihat di link berikut :
         * https://github.com/FasterXML/jackson-databind/wiki/Serialization-Features
         */

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true);//untuk menampilkan output yang lebih rapi sesuai json format

        String s = objectMapper.writeValueAsString(student);
        System.out.println(s);
    }
}
