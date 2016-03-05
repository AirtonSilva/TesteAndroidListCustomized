package entidade;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Pessoa implements Serializable {

    public Pessoa (String nome, String descricao, int id, String email) {
        this.nome = nome;
        this.descricao = descricao;
        this.id = id;
        this.email = email;
    }

	@SerializedName("id")
    private int id;

    @SerializedName("fullName")
    private String nome;

    @SerializedName("email")
    private String email;

    @SerializedName("typeInscription")
    private String descricao;

    @SerializedName("isDelivered")
    private boolean entregue;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "[fullName: " + nome + "; email: " + email + "]";
    }
}