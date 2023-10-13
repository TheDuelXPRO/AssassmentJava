import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Relatorio {
    public static void Log(String nome, Personagem heroi, String vencedor, Personagem monstro, int rounds) {
        Date agora = new Date();

        File tempDir = new File("temp");
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }

        try {
            FileWriter writer = new FileWriter("temp/" + nome + ".csv", true);
            writer.write(agora + ";" + heroi + ";" + vencedor + ";" + monstro + ";" + rounds + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
