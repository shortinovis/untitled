import java.io.*;
import java.util.ArrayList;

public class memoria {
    ArrayList<Record> memoria;
    ArrayList<Record> medie=new ArrayList<>();

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
                    memoria.add(new Record(Integer.parseInt(Split[0]), Split[1], Double.parseDouble(Split[2])));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addRecord(Record record){ return this.memoria.add(record); }
    public boolean removeRecord(Record record){ return this.memoria.remove(record); }
    public int ricercaRecord(Record record){ return this.memoria.indexOf(record); }

    //Metodo ricerca ed aggiorna
    private void ricercaAggiornaMedia(Record rg){
        int index=medie.indexOf(rg);
        if (index!=-1){ //regione già presente quindi calcolo la media
            Record r=medie.get(index);
            r.setPercentuale((r.getPercentuale()+rg.getPercentuale())/2);
        }else { //regione nuova
            medie.add(rg);
        }
    }
    private void creazioneReportCSV(){

    }


    public void reportInHtml(){
        try(BufferedReader reader=new BufferedReader(new FileReader("Users/cortinovis.21123/IdeaProjects/elaborazione csv/src/Cortinovis.csv")); PrintWriter writer=new PrintWriter(new FileWriter("cortinovis.21123/IdeaProjects/elaborazione csv/index.html",false))){
            writer.print("<!DOCTYPE html>\n<html lang=\"it\">\n<head>\n<title>Visualizzazione</title>\n" + "</head>\n<body>\n<h1>Tabella dei dati</h1>");
            writer.print("<table>\n<tr>\n");

            String intestazione=reader.readLine();
            for (String campoIntestazione : intestazione.split(";")) writer.println("<th>"+campoIntestazione.trim()+"</th>");
            writer.println("</tr>");

            String next;
            while ((next= reader.readLine())!=null) {
                writer.println("<tr>");
                for (String campoCorpo : next.split(";")) writer.println("<td>"+campoCorpo.trim()+"</td>");
                writer.println("</tr>");
            }
            writer.println("</table>\n</body>\n</html>");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
