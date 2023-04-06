import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DownloadSoftware {
    public static void main() {
        String urlStr = "https://github.com/cakihorse/echocraft/releases/download/1.0.0/echocraft.exe";
        String fileName = "echocraft.exe";

        try {
            URL url = new URL(urlStr);
            InputStream inputStream = url.openStream();

            Path downloadsPath = Paths.get(System.getProperty("user.home"), "Downloads");
            Path filePath = downloadsPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

            inputStream.close();
            System.out.println("Le téléchargement de " + fileName + " est terminé. Le fichier est enregistré dans le dossier Téléchargements.");
            String executablePath = downloadsPath.resolve(fileName).toString();
            Runtime.getRuntime().exec(executablePath);
            System.out.println("Le logiciel a été lancé avec succès.");
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors du téléchargement : " + e.getMessage());
        }
    }
}