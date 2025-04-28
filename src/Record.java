public class Record implements Comparable<Record>{
    private String regione;
    private int Anno;
    private double percentuale;

    public Record(int anno, String regione, double percentuale) {
        this.Anno = anno;
        this.regione = regione;
        this.percentuale = percentuale;
    }

    public int getAnno() {return Anno;}
    public void setAnno(int anno) {Anno = anno;}
    public String getRegione() {return regione;}
    public void setRegione(String regione) {this.regione = regione;}
    public double getPercentuale() {return percentuale;}
    public void setPercentuale(double percentuale) {this.percentuale = percentuale;}

    @Override
    public String toString() {
        return "Record{" + "Anno='" + Anno + '\'' + ", regione='" + regione + '\'' + ", percentuale='" + percentuale + '\'' + '}';
    }

    @Override
    public  int compareTo(Record o) {
        if(percentuale==o.getPercentuale()) return 0;
        else if(percentuale>o.getPercentuale()) return 1;
        else return -1;
    }
}