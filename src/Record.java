public class Record {
    private String Anno, regione, percentuale;

    public Record(String anno, String regione, String percentuale) {
        this.Anno = anno;
        this.regione = regione;
        this.percentuale = percentuale;
    }

    public String getAnno() {return Anno;}
    public void setAnno(String anno) {Anno = anno;}
    public String getRegione() {return regione;}
    public void setRegione(String regione) {this.regione = regione;}
    public String getPercentuale() {return percentuale;}
    public void setPercentuale(String percentuale) {this.percentuale = percentuale;}

    @Override
    public String toString() {
        return "Record{" + "Anno='" + Anno + '\'' + ", regione='" + regione + '\'' + ", percentuale='" + percentuale + '\'' + '}';
    }
}