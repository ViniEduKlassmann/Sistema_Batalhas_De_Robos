public class Robo{
    
    public int codigo;
    public String nome;
    public int ataque;
    public int defesa;
    public int energiaAtual = 100;
    public int vitorias = 0;
    public int derrotas = 0;
    public int pontos = 0;

    Robo( int codigo, String nome, int ataque, int defesa){
        this.codigo = codigo;
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public abstract int getNovoataque();

    public abstract int redizirdano();

    public void dadosRobo() {
        System.out.println(
            "=====================" +
            "\ncódigo do Robo: " + this.codigo +
            "\nNome do robo: " + this.nome +
            "\nAtaque do robo: " + this.ataque +
            "\nDefesa do robo: " + this.defesa +
            "\nEnergia do robo: " + this.energiaAtual +
            "\nVitorias: " + this.vitorias +
            "\nDerrotas: " + this.derrotas +
            "\nPontos: " + this.pontos +
            "\n=====================");
            
    }
}



