package WS.dao;

import WS.entity.Fornecedor;
import WS.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FornecedorDao {

    private Session se;
    private Transaction trans;
    private List<Fornecedor> list;

    public List<Fornecedor> getList() {
        Session sessao  = HibernateUtil.getSession().openSession();
       // Transaction trans = sessao .beginTransaction();
        
        Criteria cri = sessao.createCriteria(Fornecedor.class);
       
        return cri.list();
    }
    
    //Método de teste para listar fornecedores com JQL
    
    public List<Fornecedor> getListJQL(String nome) {
        Session sessao  = HibernateUtil.getSession().openSession();
        //Transaction trans = sessao .beginTransaction();
        Query query = sessao.createQuery("from Fornecedor where nome LIKE :nome");
        query.setParameter("nome", "%"+nome +"%");
        return query.list();
        //Criteria cri = sessao.createCriteria(Fornecedor.class);
       
        //return cri.list();
    }
    
    public void addFornecedor(Fornecedor f){
        try {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setNome(f.getNome());
            fornecedor.setCnpj(f.getCnpj());
            fornecedor.setTelefone(f.getTelefone());
            fornecedor.setEndereco(f.getEndereco());
            
            Session se = HibernateUtil.getSession().openSession();
        Transaction trans = se.beginTransaction();
        se.save(fornecedor);
        trans.commit();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    public void removeFornecedor(Fornecedor f){
         try {
            
        
            se = HibernateUtil.getSession().getCurrentSession();
            trans = se.beginTransaction();
           
        se.delete(f);
       trans.commit();
            
        } catch (Exception e) {
        e.printStackTrace();
        }finally{
            se.close();
        }
    }

    public void salvar(Fornecedor fornecedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public List<Fornecedor> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
