import java.util.ArrayList;
import java.util.Scanner;

class Atleta {
    String nome;
    char sexo;
    double altura;
    double peso;

    public Atleta(String nome, char sexo, double altura, double peso) {
        this.nome = nome;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Atleta> atletas = new ArrayList<>();

        System.out.print("Qual a quantidade de atletas? ");
        int N = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < N; i++) {
            System.out.println("Digite os dados do atleta numero " + (i + 1) + ":");

           
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            
            char sexo;
            while (true) {
                System.out.print("Sexo (F/M): ");
                sexo = scanner.next().toUpperCase().charAt(0);
                if (sexo == 'F' || sexo == 'M') {
                    break;
                }
                System.out.println("Valor invalido! Favor digitar F ou M.");
            }

            
            double altura;
            while (true) {
                System.out.print("Altura: ");
                altura = scanner.nextDouble();
                if (altura > 0) {
                    break;
                }
                System.out.println("Valor invalido! Favor digitar um valor positivo.");
            }

            
            double peso;
            while (true) {
                System.out.print("Peso: ");
                peso = scanner.nextDouble();
                if (peso > 0) {
                    break;
                }
                System.out.println("Valor invalido! Favor digitar um valor positivo.");
            }
            scanner.nextLine(); 

            
            atletas.add(new Atleta(nome, sexo, altura, peso));
        }

        
        double somaPeso = 0;
        double somaAlturaMulheres = 0;
        int countHomens = 0;
        int countMulheres = 0;
        Atleta atletaMaisAlto = atletas.get(0);

        for (Atleta atleta : atletas) {
            
            somaPeso += atleta.peso;

           
            if (atleta.altura > atletaMaisAlto.altura) {
                atletaMaisAlto = atleta;
            }

            
            if (atleta.sexo == 'M') {
                countHomens++;
            } else if (atleta.sexo == 'F') {
                somaAlturaMulheres += atleta.altura;
                countMulheres++;
            }
        }

        
        double pesoMedio = somaPeso / N;

        
        double porcentagemHomens = (countHomens / (double) N) * 100;

        
        String alturaMediaMulheres;
        if (countMulheres > 0) {
            alturaMediaMulheres = String.format("%.2f", somaAlturaMulheres / countMulheres);
        } else {
            alturaMediaMulheres = "Nao ha mulheres cadastradas";
        }

        // Exibindo o relatório
        System.out.println("\n### RELATORIO ###");
        System.out.printf("Peso medio dos atletas: %.2f\n", pesoMedio);
        System.out.println("Atleta mais alto: " + atletaMaisAlto.nome);
        System.out.printf("Porcentagem de homens: %.1f %%\n", porcentagemHomens);
        System.out.println("Altura media das mulheres: " + alturaMediaMulheres);

        scanner.close();
    }
}
