
package trabalhofinal;


public class Vendedor {
    private int id;
    private String nome;
    private String cpf;
    private float salario;

    public Vendedor(int id, String nome, String cpf, float salario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }
   
    public Vendedor() {
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", salario=" + salario + '}';
    }
    
    
    
}
