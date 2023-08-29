package contaTerminal.clientes;
import contaTerminal.Exception.ParametroInvalido;

public class Clientes {
    private String nome;
    private String agencia;
    private String numero;
    private double saldo;

    public Clientes(String inputNome, String inputAgencia, String inputNumero, double inputSaldo) {
        setNome(inputNome);
        setAgencia(inputAgencia);
        setNumero(inputNumero);
        setSaldo(inputSaldo);

    }

    public void setNome(String novoNome) {
        this.nome = formatarNome(novoNome);
    }

    public String getNome() {
        return nome;
    }

    public void setAgencia(String novaAgencia) {

        this.agencia = formatarAgencia(novaAgencia);
    }

    public String getAgencia() {
        return agencia;
    }

    public void setNumero(String novoNumero) {
        this.numero = formatarNumeros(novoNumero);
    }

    public String getNumero() {
        return numero;
    }

    public void setSaldo(double novoSaldo) {
        this.saldo = foramtarSaldo(novoSaldo);
    }

    public double getSaldo() {
        return saldo;
    }

    private static String formatarNome(String parametro) {
        String resultado = "";
        boolean letraAnteriorESpacoEmBranco = false;
        char[] arrayLetrasNome = parametro.toCharArray();
        for (int i = 0; i < arrayLetrasNome.length; i++) {
            char letra = arrayLetrasNome[i];
            if (Character.isWhitespace(letra)) {
                if (!letraAnteriorESpacoEmBranco)
                    resultado += letra;
                letraAnteriorESpacoEmBranco = true;
                continue;
            } else if ((letraAnteriorESpacoEmBranco == true || i == 0) && !Character.isWhitespace(letra)) {
                resultado += Character.toUpperCase(letra);

            } else {
                resultado += letra;
            }
            letraAnteriorESpacoEmBranco = false;
        }
        return resultado;
    }

    private static String formatarAgencia(String parametro) {

        if (verificaQuantidadeCaracter(parametro, 4) && verificaSeTodosCaracterSaoNumeros(parametro)) {

            return parametro.substring(0, 3) + '-' + parametro.substring(3);
        }

        if (!verificaQuantidadeCaracter(parametro, 5) || !parametro.matches("\\d{3}-\\d"))
            throw new ParametroInvalido("Agencia inválido");

        return parametro;

    }

    private String formatarNumeros(String parametros) {
        if (verificaSeTodosCaracterSaoNumeros(parametros) && verificaQuantidadeCaracter(parametros, 4))
            return parametros;
        throw new ParametroInvalido("Numeros inválido");

    }
    private double foramtarSaldo(double parametro){
        if(parametro<0)  throw new ParametroInvalido("Saldo inválido");
        return parametro;
    } 
    private static boolean verificaSeTodosCaracterSaoNumeros(String parametro) {
        if (parametro.matches("\\d+"))
            return true;
        return false;
    }

    private static boolean verificaQuantidadeCaracter(String parametro, int quantidade) {
        char[] arrayDeLetrasDaStringAgencia = parametro.toCharArray();
        if (arrayDeLetrasDaStringAgencia.length == quantidade)
            return true;
        return false;
    }
    
}
