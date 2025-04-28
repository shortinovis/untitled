import java.io.*;
import java.util.ArrayList;

public class memoria {
    ArrayList<Record> memoria;

    public memoria(File file) {
        this.memoria = new ArrayList<>();
    }

    public ArrayList<Record> getMemoria() {
        return memoria;
    }

    public void setMemoria(ArrayList<Record> memoria) {
        this.memoria = memoria;
    }

    public void carica(File file) {
        try (BufferedReader r = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s=r.readLine())!=null){
                String[]Split=s.split(";");
                if(Split.length==3){
                    memoria.add(new Record(Integer.parseInt(Split[0]), Split[1], Double.parseDouble(Split[2])))
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void medie(){

    }
}
