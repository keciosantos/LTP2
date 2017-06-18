package WS.dao;

import WS.entity.Cliente;
import WS.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDao {

    private Session se;
    private Transaction trans;
    //private List<Cliente> list;
    private String Cliente;

    public List<Cliente> getList() {
       Session sessao  = HibernateUtil.getSession().openSession();
        Transaction trans = sessao .beginTransaction();
        
        Criteria cri = sessao .createCriteria(Cliente.class);
        //this.list = cri.list();
        return cri.list();
    }
    
     public List<Cliente> getListJQL(String nome) {
        Session sessao  = HibernateUtil.getSession().openSession();
        //Transaction trans = sessao .beginTransaction();
        Query query = sessao.createQuery("from Cliente where nome LIKE :nome");
        query.setParameter("nome", "%"+nome +"%");
        //return query.list();
          Criteria cri = sessao .createCriteria(Cliente.class);
        //this.list = cri.list();
        return cri.list();
    }
    
    
    public void Inserir(Cliente d){
        try {
        
        Cliente cliente = new Cliente();
        cliente.setNome(d.getNome());
        cliente.setCpf(d.getCpf());
        cliente.setDataNascimento(d.getDataNascimento());
        cliente.setEndereco(d.getEndereco());
        
        Session se = HibernateUtil.getSession().openSession();
        Transaction trans = se.beginTransaction();
        se.save(cliente);
        trans.commit();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    
    public String removeCliente(Cliente objeto){
       
        Session se = HibernateUtil.getSession().openSession();
        Transaction trans = se.beginTransaction();
        se.update(objeto);
        se.close();
        
        /*

         entityManager.getTransaction().begin();
                              cliente = entityManager.find(Cliente.class, cliente.getId());
                              entityManager.remove(cliente);
                              entityManager.getTransaction().commit();


*/
        return String.valueOf(objeto);
    }
    //Session sessao  = HibernateUtil.getSession().openSession();
        //Query query = sessao.createQuery("delete from Cliente where id : id");
        //query.setParameter("nome", "%"+ nome +"%");
        //Criteria cri = sessao .createCriteria(Cliente.class);
        //return "OK";
    

    public void salvar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   

    public List<Cliente> buscar(String nome) {
        Session se = HibernateUtil.getSession().openSession();
        Transaction trans = se.beginTransaction();
        Query query = se.createQuery("from Cliente where nome like '" + nome+ "%'");
        query.setMaxResults(20);
        List lista = query.list();
        se.close();
        return lista;
    }

    

  

   
}
