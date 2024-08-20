package msiwms.utility;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import msi.backend.siabsen.model.AbsensiModel;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
    public static String formatFile(String filePath){
//    public static String formatFile(String rootUrl, String filePath){
        try{
            String modulFolder = filePath.substring(0, filePath.indexOf("-"));
            String employeeFolder = filePath.substring(filePath.indexOf("-")+1, filePath.lastIndexOf("-"));
            String subFolder = filePath.substring(filePath.lastIndexOf("-")+1, filePath.length());

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDateTime now = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
            String date = dtf.format(now);
    //        long current = System.currentTimeMillis();

//            String finalPath = rootUrl + modulFolder + "/" + employeeFolder + "_" + date + "/" + subFolder;
            String finalPath = modulFolder + "/" + employeeFolder + "_" + date + "/" + subFolder;
            
            finalPath = finalPath.replaceAll(" ", "_");

            return finalPath;
        }catch(Exception e){
            e.printStackTrace();
            return "Failed to format url file";
        }
        
    }
    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save file: " + fileName, ioe);
        }
    }

    public static List<String> getFileDirsFromDirectory(String dir){
        List<String> result =new ArrayList<String>();
        String opening = "/uploads/";
        
        Path uploadPath = Paths.get(dir);
        
        if (Files.exists(uploadPath)) {
            try (Stream<Path> walk = Files.walk(Paths.get(dir))) {
                // We want to find only regular files
                result = walk.filter(Files::isRegularFile)
                        .map(x -> x.toString().replace("\\", "/")).collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }   
        }
        
        //System.out.println(result);

        return result;
    }
    
    public static void deleteFile(String uploadDir, String fileName) throws IOException {
        Path uploadPath = Paths.get(uploadDir+"/"+fileName);
        try {
            Files.delete(uploadPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void replaceFile(String path, String fileName) throws IOException {
        Path uploadPath = Paths.get(path + "/" + fileName);
        Path parentDir = uploadPath.getParent();

        Files.createDirectories(uploadPath.getParent());
        try {
            // Files.delete(uploadPath);
            if (!Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
                //System.out.println("Directory " + parentDir + " created.");
            }

            if (Files.exists(uploadPath)) {
                Files.delete(uploadPath);
                //System.out.println("File " + fileName + " deleted successfully.");
            } else {
                //System.out.println("File " + fileName + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
