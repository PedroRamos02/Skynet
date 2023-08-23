import java.util.ArrayList;

public class Enxame {

    private ArrayList<Robo> robos;

    public Enxame() {robos = new ArrayList<Robo>(10);}

    public boolean adicionaRobo(Robo r) { return robos.add(r);}

    public Robo consultaRobo(String modelo) {
        for(int i = 0; i < robos.size(); i++) {
            Robo aux = robos.get(i);
            if(aux.getModelo().equals(modelo))
                return aux;
        }
        return null;
    }
}
