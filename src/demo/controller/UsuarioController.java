package demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import demo.model.Usuario;

public class UsuarioController {
	
    private Usuario jsonToUsuario(JSONObject json) {
    	
    	Usuario usuario = new Usuario();
        
    	try { 
        	usuario.setId(json.getInt("idtarefa"));
        	usuario.setNome(json.getString("nome"));
            usuario.setSenha(json.getString("senha"));               
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
    	return usuario;
        
    }
    
    private JSONObject UsuarioToJson(Usuario usuario){
        JSONObject json = new JSONObject();
        
        try { 
	        json.put("id", usuario.getId());
	        json.put("nome", usuario.getNome());
	        json.put("senha", usuario.getSenha());
	        
        }catch(JSONException e) {
        	e.printStackTrace();
        }
        
        return json;
    }

    public JSONObject Create(JSONObject json) throws SQLException, Exception{
        Usuario usuario = jsonToUsuario(json);
        usuario.Create();
        return UsuarioToJson(usuario);
    }
    
    public JSONObject Show(int id) throws SQLException, JSONException{
        Usuario usuario = new Usuario();
        try{
        	usuario.Read(id);
            return UsuarioToJson(usuario);
       } catch (Exception ex) {
            JSONObject json = new JSONObject();
            json.put("erro", ex.getMessage());
            return json;
        }
    }
    
    public JSONObject Edit(JSONObject json) throws SQLException{
    	Usuario usuario = jsonToUsuario(json);
    	usuario.Update();
    	return UsuarioToJson(usuario);
    }
    
    
    public JSONArray Index() throws SQLException{
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = usuario.All();
        JSONArray json = new JSONArray();
        usuarios.forEach(user -> {
            json.put(UsuarioToJson(user));
        });
        return json;
    }
    
    public JSONObject Delete (int id) throws SQLException, JSONException{
    	Usuario usuario = new Usuario();
        try {
        	usuario.Read(id);
        	usuario.Delete();
            return UsuarioToJson(usuario);
        } catch (Exception ex) {
            JSONObject json = new JSONObject();
            json.put("erro", ex.getMessage());
            return json;
        }
    }
}
