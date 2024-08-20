package msiwms.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DateFormatUtil {
    public static ArrayList<LocalDate> DateRangeTextToLocalDateConverter(String tanggalAbsensi1, String tanggalAbsensi2){

        ArrayList<LocalDate> dates = new ArrayList<LocalDate>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        if (tanggalAbsensi1.charAt(2) == '/' && tanggalAbsensi2.charAt(2) == '/'){
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        }

        LocalDate tanggalAbsensi1Formatted = LocalDate.parse(tanggalAbsensi1.replaceAll("'",""), formatter);
        LocalDate tanggalAbsensi2Formatted = LocalDate.parse(tanggalAbsensi2.replaceAll("'",""), formatter);

        DateTimeFormatter formatterDb = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tanggalAbsensiStart = LocalDate.parse(tanggalAbsensi1Formatted.format(formatterDb));
        dates.add(tanggalAbsensiStart);
        LocalDate tanggalAbsensiEnd = LocalDate.parse(tanggalAbsensi2Formatted.format(formatterDb));
        dates.add(tanggalAbsensiEnd);

        return dates;
    }



    public static ArrayList<LocalDateTime> DateRangeTextToLocalDateTimeConverter(String waktuCheckIn, String waktuCheckOut){

        ArrayList<LocalDateTime> dates = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");

        LocalDateTime tanggalAbsensi1Formatted = LocalDateTime.parse(waktuCheckIn.replaceAll("'",""), formatter);
        LocalDateTime tanggalAbsensi2Formatted = LocalDateTime.parse(waktuCheckOut.replaceAll("'",""), formatter);

        DateTimeFormatter formatterDb = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime tanggalAbsensiStart = LocalDateTime.parse(tanggalAbsensi1Formatted.format(formatterDb));
        dates.add(tanggalAbsensiStart);
        LocalDateTime tanggalAbsensiEnd = LocalDateTime.parse(tanggalAbsensi2Formatted.format(formatterDb));
        dates.add(tanggalAbsensiEnd);

        return dates;
    }
    
    public static LocalDateTime addLeadingZeroToLocalDateTime(LocalDateTime waktu){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        
        return LocalDateTime.parse(waktu.format(formatter));
        
    }



    public static String LocalDateTimeToLocalDateFormatter(LocalDateTime localDateTime){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return localDateTime.format(dateFormat);
    }

    public static String LocalDateTimeToSDFOutFormatter(LocalDateTime localDateTime){
        DateTimeFormatter CheckInFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy - HH:mm:ss");

        return localDateTime.format(CheckInFormatter);
    }
    
    public static String LocalDateToSDFOutFormatter(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

        return localDate.format(formatter);
    }
    
    
    public static String LocalDateToDDMMMYYYYWithStripFormatter(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        return localDate.format(formatter);
    }
    
    public static LocalDate StringDDMMMYYYYWithStripToLocalDateConverter(String localDateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        
        LocalDate tanggalFormatted = LocalDate.parse(localDateString.replaceAll("'",""), formatter);
        DateTimeFormatter formatterDb = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(tanggalFormatted.format(formatterDb));
    }
}
