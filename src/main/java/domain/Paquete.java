package domain;

public final class Paquete {
    private int id;
    private String origen;
    private String destino;
    private float peso;
    
    public Paquete(){
        
    }
    
    public Paquete(int id, String origen, String destino, float peso){
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("id: ").append(this.id);
        sb.append("\nOrigen: ").append(this.origen);
        sb.append("\nDestino: ").append(this.destino);
        sb.append("\nPeso: ").append(this.peso);
        
        return sb.toString();
    }
}
