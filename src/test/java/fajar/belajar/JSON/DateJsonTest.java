package fajar.belajar.JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateJsonTest {

    /** Date Time
     * Saat kita membuat object Java, kita sering menambah field dengan tipe data Date Time, misal java.util.Date, java.util.Calendar, dan lain-lain
     * JSON tidak memiliki tipe data Date Time
     * Biasanya ketika menggunakan JSON, untuk menampilkan tipe data Date Time, kita memiliki beberapa pilihan, menampilkan dengan number (format milis) atau dengan string (misal format yyyy-MM-dd)
     * Jackson secara default akan menampilkan Date Time dalam format number (milis)
     */


    /** Date Time Non Milis
     * Jika kita tidak ingin menggunakan milis ketika membuat atau membaca JSON, kita bisa gunakan juga string sebagai representasi Date Time nya
     * Namun kita perlu memberitahu Date Format yang akan digunakan oleh Jackson
     * Kita bisa ubah Date Formatter di ObjectMapper, dan menon-aktifkan fitur milis untuk Date Time
     */


    @Test
    @SneakyThrows
    void testCreateDateJson() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Student student = new Student();
        student.setFirstName("fajar abdillah");
        student.setLastName("ahmad");
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
