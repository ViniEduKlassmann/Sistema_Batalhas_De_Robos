import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);
        ArrayList<Robo> robos = new ArrayList<>();
        int opt = -1;
        do {
            System.out.println("====cadastro de robos====");
            System.out.println("0. SAIR");
            System.out.println("1. Cadastrar um novo robo:");
            System.out.println("2. Buscar robo:");
            System.out.println("3. Exibir robos cadastrados:");
            System.out.println("4. Realizar um combate:");
            System.out.println("5. Recuperar energia:");
            System.out.println("6. Rodada Geral:");
            System.out.println("7. Exibir classificação:");
            System.out.println("8. Emitir estatística:");
            System.out.println("9. Excluir participante:");
            opt = buscarOperacao(dado);
            switch (opt) {

                case 0:
                    System.out.println("Programa encerrado!");
                    break;
                case 1:
                    System.out.println("Digite o código do robo:");
                    int codigo;
                    boolean codigoExiste;
                    ;
                    do {
                        codigo = dado.nextInt();
                        codigoExiste = false;
                        for (Robo r : robos) {
                            if (r.codigo == codigo) {
                                codigoExiste = true;
                            }
                        }

                        if (codigo <= 0) {
                            System.out.println("O código não pode ser menor ou igual a 0, digite outro código:");
                        }

                        else if (codigoExiste == true) {
                            System.out.println("Digite outro codigo, esse já existe:");
                        }

                    } while (codigo <= 0 || codigoExiste == true);
                     
                    dado.nextLine();
                    
                    System.out.println("Digite o nome do robo:");
                    String nome;
                    
                    do{
                        nome = dado.nextLine();
                        if(nome.isEmpty()) {
                            System.out.println("O nome não pode ser vazio, preencha um nome!");
                        }
                    }while (nome.isEmpty());
                        
                    
                    System.out.println("Qual o valor de ataque do robo que vai de 10 a 30:");
                    int ataque;
                    do {
                        ataque = dado.nextInt();
                        if (ataque < 10 || ataque > 30) {
                            System.out.println("valor invalido, digite um valor válido:");
                        }
                    } while (ataque < 10 || ataque > 30);
                    System.out.println("Qual o valor de defesa do robo que vai de 0 a 20:");
                    int defesa;
                    do {
                        defesa = dado.nextInt();
                        if (defesa < 0 || defesa > 20) {
                            System.out.println("Valor inválido, digite um valor válido:");
                        }
                    } while (defesa < 0 || defesa > 20);
                    Robo robo = new Robo(
                            codigo,
                            nome,
                            ataque,
                            defesa);
                    robos.add(robo);
                break;

                case 2:
                System.out.println("Informe o código do robô: ");
                int codBuscar = dado.nextInt();
 
                    for (Robo r : robos) {
                        if (r.codigo == codBuscar) {
                            r.dadosRobo();
                        }
                    }
                    break;

                case 3:
                    for(Robo c : robos){
                        c.dadosRobo();
                    }
                    break;

                case 4:
                    System.out.println("Digite o código do 1° robo para a batalha:");
                    int codigo1 = dado.nextInt();
                    System.out.println("Digite o código do 2° robo para a batalha:");
                    int codigo2 = dado.nextInt();

                    Robo robo1 = null;
                    Robo robo2 = null;

                    for(Robo d : robos){
                        if(d.codigo == codigo1){
                            robo1 = d;
                        }
                        if(d.codigo == codigo2){
                            robo2 = d;
                        }
                    }

                    if(robo1 == null || robo2 == null){
                        System.out.println("Verifique os códigos, pelo menos um dos robos não existe");
                    }
                    else if(robo1 == robo2){
                        System.out.println("Os códigos dos robos são iguais!");
                    }
                    else if(robo1.energiaAtual < 30 || robo2.energiaAtual < 30){
                        System.out.println("Pelo menos um dos robos não tem energia suficiente!");
                    }
                    else{
                        
                    }

                    break;
            }
        } while (opt != 0);
        dado.close();
    }

    public static int buscarOperacao(Scanner dado) {
        int opt = -1;
        do {
            try {
                opt = dado.nextInt();
            } catch (InputMismatchException e) {
                dado.nextLine();
                System.out.println("Operação inválida!");
                System.out.println("Digite a opção novamente:");
                opt = -1;
            }
        } while (opt < 0);

        return opt;
    }
}
