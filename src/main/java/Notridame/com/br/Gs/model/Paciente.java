package Notridame.com.br.Gs.model;



public class Paciente{
    private String nome;
    private int idade;
    private String sexo;
    private String endereco;
    private String cpf;
    private String senha;




    public Paciente(String nome, int idade, String sexo , String endereco, String cpf, String senha ) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cpf = cpf;
        this.senha = senha;

    }


    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }



}
