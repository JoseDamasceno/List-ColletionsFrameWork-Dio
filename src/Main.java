import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Gato> seusGatos = new ArrayList<>(){{
            add(new Gato("joh", 18, "preto"));
            add(new Gato("Simba",12, "amarelo"));
            add(new Gato("joh",8, "sinza"));
        }};

        System.out.println("======Ordem de Inserção:=======");
        System.out.println(seusGatos);
        System.out.println("======Ordem  Aleatoria=====");
        Collections.shuffle(seusGatos);//Collections.shuffle Lista Aleatoria.
        System.out.println(seusGatos);
        System.out.println("======Ordem Natural=====");
        Collections.sort(seusGatos);//Ordem Natural passado com compareTo
        System.out.println(seusGatos);
        System.out.println("======Ordem Idade=====");
        Collections.sort(seusGatos,new ComparatorAge());
        //seusGatos.sort(new ComparatorAge());//Forma numero 2 de comparar idade
        System.out.println(seusGatos);
        System.out.println("======Ordem Cor=====");
        Collections.sort(seusGatos,new ComparatorColor());
        System.out.println(seusGatos);
        System.out.println("======Ordem Cor/Idade/Nome=====");
        Collections.sort(seusGatos,new ComparatorNomeCorIdade());
        System.out.println(seusGatos);


    }
}
        class Gato implements Comparable<Gato>{
            private String name;
            private Integer age;
            private String color;

            public String getName() {
                return name;
            }

            public Integer getIdade() {
                return age;
            }

            public String getCor() {
                return color;
            }

            @Override
            public String toString() {
                return "" +
                        "nome:  " + name + '\'' +
                        ", idade:  " + age +
                        ", cor:  " + color + '\'' + '|'
                        ;
            }

            public Gato(String name, Integer idade, String cor) {
                this.name = name;
                this.age = idade;
                this.color = cor;

    }

            @Override
            public int compareTo(Gato gato) {  // interface que compara a ordem natural da List
                return this.getName().compareToIgnoreCase(gato.getName());
            }

}
class ComparatorAge implements Comparator<Gato>{
    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(),g2.getIdade());
    }
}
class ComparatorColor implements Comparator<Gato>{

    @Override
    public int compare(Gato o1, Gato o2) {
        return o1.getCor().compareToIgnoreCase(o1.getCor());
    }
}
class ComparatorNomeCorIdade implements Comparator<Gato>{
    @Override
    public int compare(Gato g1, Gato g2) {
        int name = g1.getName().compareToIgnoreCase(g2.getName());
        if (name!=0) return name;

        int color =g1.getCor().compareToIgnoreCase(g2.getCor());
        if (color !=0) return color;

       return Integer.compare(g1.getIdade(),g2.getIdade());
    }
}

