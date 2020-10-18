package demo.model;

import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {
	
	private Integer id;
    private String nome;
    private String senha;    

    public Usuario() {
    }

    public Usuario(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario = [id=" + id + ", nome=" + nome + ", senha=" + senha + "]";
	}
        
    
    public void Create() {
        System.out.println("Abrindo conexão com o banco de dados!");
        System.out.println(this.toString());
        String sql = "INSERT INTO usuario (nome) VALUES (?) ";
        System.out.println(sql);
        System.out.println("Fechando conexão com o banco de dados");
    }
    
    public void Read(int id){
    	System.out.println("Abrindo conexão com o banco de dados!");
        System.out.println(this.toString());
        String sql = "SELECT * FROM usuario WHERE idusuario = ?";
        System.out.println(sql);
        System.out.println("Fechando conexão com o banco de dados");
    }
    
    public void Update(){
    	System.out.println("Abrindo conexão com o banco de dados!");
        System.out.println(this.toString());
        String sql = "UPDATE usuario SET nome = ? where idusuario = ?";
        System.out.println(sql);
        System.out.println("Fechando conexão com o banco de dados");
    }
    
      
    public void Delete() {
    	System.out.println("Abrindo conexão com o banco de dados!");
        System.out.println(this.toString());
        String sql = "DELETE FROM usuario WHERE idusuario= ?";
        System.out.println(sql);
        System.out.println("Fechando conexão com o banco de dados");
    }
    
    public ArrayList<Usuario> All() throws SQLException{
    	System.out.println("Abrindo conexão com o banco de dados!");
        System.out.println(this.toString());
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        System.out.println(sql);
        
        Usuario usuario = new Usuario (1, "Thiago Alves", "123456");        
        usuarios.add(usuario);
        
        System.out.println("Fechando conexão com o banco de dados");
        return usuarios;
    }
	
}
