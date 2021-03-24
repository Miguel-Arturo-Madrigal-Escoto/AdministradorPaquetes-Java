package domain;

import java.util.*;
import java.io.*;

public final class Paqueteria {
    private LinkedList<Paquete> paquetes;

    public Paqueteria() {
        paquetes = new LinkedList<>();
    }

    public void insertarInicio(Paquete paquete) {
        paquetes.addFirst(paquete);
    }

    public void eliminarInicio() {
        try {
            paquetes.removeFirst();
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Error al eliminar: " + ex.getMessage());
        }

    }

    public void ordenarOrigen() {
        Comparator<Paquete> compararOrigen = (Paquete p1, Paquete p2) -> p1.getOrigen().compareTo(p2.getOrigen());

        Collections.sort(paquetes, compararOrigen);
    }

    public void ordenarPeso() {
        Collections.sort(paquetes, new Comparator<Paquete>() {
            @Override
            public int compare(Paquete p1, Paquete p2) {
                return Float.compare(p2.getPeso(), p1.getPeso());
            }

        });
    }

    public void mostrar() {
        System.out.println(" * * Lista de paquetes * * ");
        paquetes.forEach((var paquete) -> {
            System.out.println(paquete + "\n");
        });
    }

    public void guardar() {
        File file = new File(
                "C:\\Users\\PC\\Documents\\SSPA_21A\\Actividad01\\src\\main\\java\\archivos\\paquetes.txt");
        try {
            try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
                paquetes.forEach(paquete -> {
                    pw.println(paquete.getId());
                    pw.println(paquete.getOrigen());
                    pw.println(paquete.getDestino());
                    pw.println(paquete.getPeso());
                });

                pw.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void recuperar() {
        File file = new File(
                "C:\\Users\\PC\\Documents\\SSPA_21A\\Actividad01\\src\\main\\java\\archivos\\paquetes.txt");
        Paquete paquete;

        int id;
        String origen, destino;
        float peso;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            var linea = br.readLine();

            while (linea != null) {
                id = Integer.parseInt(linea);

                linea = br.readLine();
                origen = linea;

                linea = br.readLine();
                destino = linea;

                linea = br.readLine();
                peso = Float.parseFloat(linea);

                paquete = new Paquete(id, origen, destino, peso);
                paquetes.add(paquete);

                linea = br.readLine();
            }

            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
