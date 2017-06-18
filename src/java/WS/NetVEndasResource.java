
package WS;

import WS.dao.ClienteDao;
import WS.entity.Cliente;
import WS.entity.Fornecedor;
import WS.dao.FornecedorDao;
import WS.dao.ProdutoDao;
import static WS.entity.Cliente_.cpf;
import static WS.entity.Cliente_.dataNascimento;
import static WS.entity.Cliente_.endereco;
import static WS.entity.Cliente_.nome;
import WS.entity.Produto;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author keciosantos
 */
@Path("NetVEndas")
public class NetVEndasResource {

    @Context
    private UriInfo context;

    public NetVEndasResource() {
    }

    @GET
    @Produces("application/json")
    public String getJdon() {
        return"Teste";
    }
    
    @GET
    @Produces("application/json")
    @Path("Cliente/get/{nome}")
    public String getClientes(@PathParam("nome") String nome){     
        ClienteDao dao = new ClienteDao();
        List<Cliente> lista = dao.buscar(nome);
        
        Gson g = new Gson();
        return g.toJson(lista);  
       
    }
    
    @GET
    @Produces("application/json")
    @Path("Cliente/list")
    public String listClientes(){
        List<Cliente> lista;
        
        ClienteDao dao = new ClienteDao();
         lista = dao.getList();
        
        Gson g = new Gson();
        return g.toJson(lista);       
    }
    @POST
    @Consumes("application/json")
    @Path("Cliente/add")
    public Response addCliente(Cliente Cliente){
        ClienteDao dao = new ClienteDao();
        dao.Inserir(Cliente);
        return Response.status(Response.Status.OK).build();
    }
    
    @GET
    @Produces("application/json")
    @Path("Fornecedor/list")
    public String listfornecedor(){
        List<Fornecedor> lista;
        
        FornecedorDao fdao = new FornecedorDao();
        lista = fdao.getList();
        
        Gson g = new Gson();
        return g.toJson(lista);       
    }
    
    @GET
    @Produces("application/json")
    @Path("Produto/list")
    public String listproduto(){
        List<Produto> lista;
        
        ProdutoDao pdao = new ProdutoDao();
        lista = pdao.getList();
        
        Gson g = new Gson();
        return g.toJson(lista);       
    }
    
    @POST
    @Consumes("applicatoin/json")
    @Path("Cliente/Cria/")
    public Response addCliente(){
        return Response.status(Response.Status.OK).build();
    }
    
    /**
     * PUT method for updating or creating an instance of NetVEndasResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    
    public void putJson(String content) {
    }
    /*
    @DELETE
    @Consumes("application/json")
    @Path("Cliente/excluir/{nome}")
    public String remover(@PathParam("nome") String nome){     
        ClienteDao dao = new ClienteDao();
        List<Cliente> lista = dao.buscar(nome);
        
            return dao.removeCliente(lista);
       
    }*/
    
    @DELETE
    @Consumes("application/json")
    @Path("Cliente/excluir/{nome}")
        public String removeCliente(@PathParam("nome") String nome ,@PathParam("id") int id){     
         ClienteDao dao = new ClienteDao();
        List<Cliente> lista = dao.buscar(nome);
        for(Cliente cliente : lista){
            if(cliente.getNome().equals(nome)){
                id= cliente.getId();
                
                return String.valueOf(id);
            }
        }
        return String.valueOf(id);
    }

}
