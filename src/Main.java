import java.util.ArrayList;

class Cor {
    // Classe Cor simulada. Defina as cores conforme necessário.
}

interface Figura {
    void desenha();
    void mudaCorDeFundo(Cor cor);
}

class Circulo implements Figura {
    @Override
    public void desenha() {
        System.out.println("Desenhando um círculo.");
    }

    @Override
    public void mudaCorDeFundo(Cor cor) {
        System.out.println("Mudando a cor de fundo do círculo.");
    }
}

class Triangulo implements Figura {
    @Override
    public void desenha() {
        System.out.println("Desenhando um triângulo.");
    }

    @Override
    public void mudaCorDeFundo(Cor cor) {
        System.out.println("Mudando a cor de fundo do triângulo.");
    }
}

class FiguraAgrupada implements Figura {
    private ArrayList<Figura> figuras = new ArrayList<>();

    // Adiciona uma figura ao grupo
    public void adicionar(Figura fig) {
        figuras.add(fig);
    }

    // Remove uma figura do grupo
    public void remover(Figura fig) {
        figuras.remove(fig);
    }

    // Desenha todas as figuras do grupo
    @Override
    public void desenha() {
        for (Figura fig : figuras) {
            fig.desenha();
        }
    }

    // Muda a cor de fundo de todas as figuras do grupo
    @Override
    public void mudaCorDeFundo(Cor cor) {
        for (Figura fig : figuras) {
            fig.mudaCorDeFundo(cor);
        }
    }
}

class Cliente {
    void foo(Figura fig) {
        fig.desenha(); // desenha figura simples ou agrupada
    }
}

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        // Cria um círculo e chama foo com a figura simples
        Circulo c1 = new Circulo();
        cliente.foo(c1);

        // Cria dois triângulos
        Triangulo t1 = new Triangulo();
        Triangulo t2 = new Triangulo();

        // Cria um grupo de figuras e adiciona o círculo e os triângulos
        FiguraAgrupada grupo = new FiguraAgrupada();
        grupo.adicionar(c1);
        grupo.adicionar(t1);
        grupo.adicionar(t2);

        // Chama foo com a figura agrupada
        cliente.foo(grupo);

        // Cria outro grupo de figuras, que inclui o primeiro grupo
        FiguraAgrupada grupo2 = new FiguraAgrupada();
        grupo2.adicionar(grupo); // figura agrupada contendo outra figura agrupada

        // Chama foo com a figura agrupada aninhada
        cliente.foo(grupo2);
    }
}
