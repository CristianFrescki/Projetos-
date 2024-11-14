import java.util.Scanner;

public class Lampada {
    
    private String marca;
    private String voltagem;
    private String tipo;
    private String modelo;
    private String cor;
    private double preco;
    private String garantia;
    private boolean ligada;

    
    public Lampada(String marca, String voltagem, String tipo, String modelo, String cor, double preco, String garantia) {
        this.marca = marca;
        this.voltagem = voltagem;
        this.tipo = tipo;
        this.modelo = modelo;
        this.cor = cor;
        this.preco = preco;
        this.garantia = garantia;
        this.ligada = false;
    }

    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(String voltagem) {
        this.voltagem = voltagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public boolean isLigada() {
        return ligada;
    }

    
    public void ligar() {
        if (!ligada) {
            ligada = true;
            System.out.println("# Lâmpada Ligada #");
        }
    }

    public void desligar() {
        if (ligada) {
            ligada = false;
            System.out.println("# Lâmpada Desligada #");
        }
    }

    public void mostrarStatus() {
        String status = ligada ? "Ligada" : "Desligada";
        System.out.println("STATUS: " + status);
    }

    public void mudarStatus() {
        if (ligada) {
            desligar();
        } else {
            ligar();
        }
    }

    
    public void mostrarInformacoes() {
        System.out.println(">>> INÍCIO DO SOFTWARE DA LÂMPADA <<<");
        System.out.println("COR: " + cor);
        System.out.println("MARCA: " + marca);
        System.out.println("MODELO: " + modelo);
        System.out.println("WATTS: " + voltagem);
        System.out.println("TIPO: " + tipo);
        System.out.println("GARANTIA: " + garantia);
        System.out.printf("PREÇO – R$: %.2f\n", preco);
        mostrarStatus();
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a marca da lâmpada: ");
        String marca = scanner.nextLine();

        System.out.print("Informe a voltagem da lâmpada: ");
        String voltagem = scanner.nextLine();

        System.out.print("Informe o tipo da lâmpada: ");
        String tipo = scanner.nextLine();

        System.out.print("Informe o modelo da lâmpada: ");
        String modelo = scanner.nextLine();

        System.out.print("Informe a cor da lâmpada: ");
        String cor = scanner.nextLine();

        System.out.print("Informe o preço da lâmpada: ");
        double preco = scanner.nextDouble();

        scanner.nextLine(); 

        System.out.print("Informe a garantia da lâmpada: ");
        String garantia = scanner.nextLine();

        Lampada lampada = new Lampada(marca, voltagem, tipo, modelo, cor, preco, garantia);
        lampada.mostrarInformacoes();

        while (true) {
            System.out.println("Ligar/Desligar lâmpada? 0 – Sair / 1 – Sim / 2 – Não");
            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("*** Você encerrou o software. ***");
                break;
            } else if (opcao == 1) {
                lampada.mudarStatus();
            } else if (opcao == 2) {
                lampada.mostrarStatus();
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
