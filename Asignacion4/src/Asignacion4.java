import Asignacion4.implementaciones.ArrayList;

public class Asignacion4 {

    public static void main(String[] args) {
        System.out.println("===== Peubas =====");
        ArrayList<String> paises = new ArrayList<>(String.class, 5);

        paises.append("Japon");
        paises.append("España");
        paises.append("Mexico");
        paises.append("USA");

        System.out.println("Lista inicial: " + paises.toString());
        System.out.println("Numero de elementos actual: " + paises.size());
        System.out.println("=================================================");

        System.out.println("Prueba indexOf: (Mexico)");
        int indice = paises.indexOf("Mexico");
        System.out.println("El indice de Mexico es: " + indice);
        System.out.println("=================================================");

        System.out.println("Prueba removeObj (Japon)");
        boolean seBorra = paises.remove("Japon");
        System.out.println("Se borra el Objeto?? " + seBorra);
        System.out.println("Lista actualizada: " + paises.toString());
        System.out.println("=================================================");

        System.out.println("Pueba Clear");
        paises.clear();
        System.out.println("Lista final: " + paises.toString());
        System.out.println("Numero de elementos final: " + paises.size());
    }
    
}
