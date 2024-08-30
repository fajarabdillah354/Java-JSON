package fajar.belajar.JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaBeanTest {

    /** Konversi Object ke JSON
     * Salah satu kekurangan menggunakan Map ketika membuat JSON Object adalah, kita harus melakukan input data secara manual satu per satu ke dalam Map nya
     * Di Java, biasanya tipe data akan dibuat dalam bentuk class Java Bean (getter setter)
     * Jackson juga bisa otomatis melakukan konversi Object menjadi JSON secara otomatis, dimana attribute JSON nya akan menggunakan nama field di class nya
     * Jika Object tersebut memiliki field dengan tipe data Object lain, Jackson juga akan otomatis membuat embedded Object atau Array secara otomatis
     */


    //direkomendasikan membuat class dulu sebelum bikin jsonnya,

    @Test
    @SneakyThrows
    void testJsonFromObject() {
        Student student = new Student();
        student.setFirstName("fajar abdillah");
        student.setLastName("ahmad");
        student.setGrade(3);


        Address address = new Address();
        address.setStreet("Radar Selatan");
        address.setCity("Pondok Gede");
        address.setCountry("indonesia");

        ObjectMapper mapper = new ObjectMapper();
        String value1 = mapper.writeValueAsString(student);
        String value2 = mapper.writeValueAsString(address);

        System.out.println(value1);
        System.out.println(value2);


    }


    /* Konversi JSON ke Object
        * Untuk melakukan konversi JSON ke dalam object class Java Bean, kita bisa melakukan dengan cara hal yang sama ketika melakukan konversi ke Map atau List
        * Hanya saja, parameternya tidak perlu menggunakan TypeReference lagi, kita bisa langsung sebutkan nama class Java Bean nya

     */

    @Test
    @SneakyThrows
    void testReadObjectFromJson() {
        String json = """
                    {"city":"Pondok Gede","street":"Radar Selatan","country":"indonesia"}
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Address address = objectMapper.readValue(json, Address.class);

        Assertions.assertEquals("Pondok Gede", address.getCity());
        Assertions.assertEquals("Radar Selatan", address.getStreet());

    }
}
