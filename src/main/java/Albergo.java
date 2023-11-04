package src.main.java;

public class Albergo {
    private int id;
    private String comune;
    private String provincia;
    private String stelle;
    private String denominazione;

    public Albergo(int id, String comune, String provincia, String stelle, String denominazione) {
        this.id = id;
        this.comune = comune;
        this.provincia = provincia;
        this.stelle = stelle;
        this.denominazione = denominazione;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComune() {
        return this.comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getStelle() {
        return this.stelle;
    }

    public void setStelle(String stelle) {
        this.stelle = stelle;
    }

    public String getDenominazione() {
        return this.denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", comune='" + getComune() + "'" +
            ", provincia='" + getProvincia() + "'" +
            ", stelle='" + getStelle() + "'" +
            ", denominazione='" + getDenominazione() + "'" +
            "}";
    }

    public String toXMLString() {
        return "\t<albergo id=\""+getId()+"\">"+
        "\n\t\t<comune>"+getComune()+"</comune>"+
        "\n\t\t<provincia>"+getProvincia()+"</provincia>"+
        "\n\t\t<stelle>"+getStelle()+"</stelle>"+
        "\n\t\t<denominazione>"+getDenominazione()+"</denominazione>"+
        "\n\t</albergo>\n";
    }
    
}
