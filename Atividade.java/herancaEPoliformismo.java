class Veiculo {
    protected String modelo;
    protected int ano;

    public Veiculo(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public void imprimirInformacoes() {
        System.out.println("Modelo: " + modelo + ", Ano: " + ano);
    }
}

class Carro extends Veiculo {
    private int portas;
    private String combustivel;

    public Carro(String modelo, int ano, int portas, String combustivel) {
        super(modelo, ano);
        this.portas = portas;
        this.combustivel = combustivel;
    }

    public void ligarArCondicionado() {
        System.out.println("Ar-condicionado ligado!");
    }

    public void imprimirInformacoes() {
        System.out.println("Carro -> Modelo: " + modelo + ", Ano: " + ano +
                           ", Portas: " + portas + ", Combustível: " + combustivel);
    }
}

class Moto extends Veiculo {
    private int cilindradas;
    private boolean partidaEletrica;

    public Moto(String modelo, int ano, int cilindradas, boolean partidaEletrica) {
        super(modelo, ano);
        this.cilindradas = cilindradas;
        this.partidaEletrica = partidaEletrica;
    }

    public void empinar() {
        System.out.println("Moto empinando!");
    }

    public void imprimirInformacoes() {
        System.out.println("Moto -> Modelo: " + modelo + ", Ano: " + ano +
                           ", Cilindradas: " + cilindradas + ", Partida Elétrica: " + partidaEletrica);
    }
}

class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public void emitirSom() {
        System.out.println(nome + " emite um som genérico.");
    }
}

class Mamifero extends Animal {
    public Mamifero(String nome) {
        super(nome);
    }

    public void emitirSom() {
        System.out.println(nome + " diz: 'grrrr'");
    }
}

class Ave extends Animal {
    public Ave(String nome) {
        super(nome);
    }

    public void emitirSom() {
        System.out.println(nome + " diz: 'piu piu'");
    }
}

class Peixe extends Animal {
    public Peixe(String nome) {
        super(nome);
    }

    public void emitirSom() {
        System.out.println(nome + " diz: 'blub blub'");
    }
}

class ContaBancaria {
    protected double saldo;
    protected String numeroConta;

    public ContaBancaria(String numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void aplicarJuros() {
    }
}

class ContaCorrente extends ContaBancaria {
    public ContaCorrente(String numeroConta, double saldo) {
        super(numeroConta, saldo);
    }

    public void aplicarJuros() {
        saldo += saldo * 0.15;
    }
}

class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String numeroConta, double saldo) {
        super(numeroConta, saldo);
    }

    public void aplicarJuros() {
        saldo += saldo * 0.065;
    }
}

class Calculadora {
    public int soma(int a, int b) { return a + b; }
    public double soma(double a, double b) { return a + b; }
    public int subtracao(int a, int b) { return a - b; }
    public double subtracao(double a, double b) { return a - b; }
    public int multiplicacao(int a, int b) { return a * b; }
    public double multiplicacao(double a, double b) { return a * b; }
    public int divisao(int a, int b) { return a / b; }
    public double divisao(double a, double b) { return a / b; }
}

abstract class FormaGeometrica {
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}

class Circulo extends FormaGeometrica {
    private double raio;
    public Circulo(double raio) { this.raio = raio; }
    public double calcularArea() { return Math.PI * raio * raio; }
    public double calcularPerimetro() { return 2 * Math.PI * raio; }
}

class Retangulo extends FormaGeometrica {
    private double largura, altura;
    public Retangulo(double largura, double altura) { this.largura = largura; this.altura = altura; }
    public double calcularArea() { return largura * altura; }
    public double calcularPerimetro() { return 2 * (largura + altura); }
}

class Triangulo extends FormaGeometrica {
    private double base, altura;
    public Triangulo(double base, double altura) { this.base = base; this.altura = altura; }
    public double calcularArea() { return (base * altura) / 2; }
    public double calcularPerimetro() { return 3 * base; }
}

    interface Autenticavel {
    boolean autenticar(String senha);
}

class Usuario implements Autenticavel {
    private String nome;
    private String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() { return nome; }

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}

class Administrador implements Autenticavel {
    private String nome;
    private String senha;

    public Administrador(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}

public class herancaEPoliformismo {
    public static void main(String[] args) {
        System.out.println("=== TESTE VEÍCULOS ===");
        Carro c = new Carro("Sedan", 2023, 4, "Gasolina");
        Moto m = new Moto("Naked", 2022, 600, true);
        c.imprimirInformacoes();
        c.ligarArCondicionado();
        m.imprimirInformacoes();
        m.empinar();

        System.out.println("\n=== TESTE ANIMAIS ===");
        Animal[] animais = { new Mamifero("Leão"), new Ave("Papagaio"), new Peixe("Dourado") };
        for (Animal a : animais) a.emitirSom();

        System.out.println("\n=== TESTE CONTAS ===");
        ContaCorrente cc = new ContaCorrente("001", 1000);
        ContaPoupanca cp = new ContaPoupanca("002", 1000);
        cc.aplicarJuros();
        cp.aplicarJuros();
        System.out.println("Saldo CC: " + cc.getSaldo());
        System.out.println("Saldo CP: " + cp.getSaldo());

        System.out.println("\n=== TESTE CALCULADORA ===");
        Calculadora calc = new Calculadora();
        System.out.println("Soma int: " + calc.soma(10, 5));
        System.out.println("Soma double: " + calc.soma(10.5, 5.2));

        System.out.println("\n=== TESTE FORMAS GEOMÉTRICAS ===");
        FormaGeometrica f1 = new Circulo(5);
        System.out.println("Área do Círculo: " + f1.calcularArea());
        System.out.println("Perímetro do Círculo: " + f1.calcularPerimetro());

        System.out.println("\n=== TESTE AUTENTICAÇÃO ===");
        Autenticavel[] usuarios = { new Usuario("João", "123"), new Administrador("Maria", "admin") };
        for (Autenticavel u : usuarios) {
            String nome = (u instanceof Usuario) ? ((Usuario) u).getNome() : ((Administrador) u).getNome();
            System.out.println("Usuário: " + nome + " | Autenticado? " + u.autenticar("123"));
        }
    }
}