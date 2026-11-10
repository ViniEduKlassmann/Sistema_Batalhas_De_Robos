public class Defensivo extends Robo {

    public Defensivo(int codigo, String nome, int ataque, int defesa ){
        super( codigo,nome, ataque, defesa);
    }

    public int getAtaque(){
        return this.ataque;
    }

    public int reduzirDano(int dano){
        int reduzido = dano - 3;
        if (reduzido < 2) {
            reduzido =2;
        }
        return reduzido;
    }
    
}
