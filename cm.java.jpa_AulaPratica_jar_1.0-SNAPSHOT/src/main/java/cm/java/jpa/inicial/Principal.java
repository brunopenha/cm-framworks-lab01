package cm.java.jpa.inicial;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Principal {

    public static void main(String args[]) {

        // 1 - Crio uma instancia de Pessoa
        Pessoa pessoa = new Pessoa("1111111111","Bruno", "Penha");

        // 2 - Obtem um gerenciador de entidades e uma transação
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("cmJavaJPA");

        EntityManager em = emf.createEntityManager();

        // 3 - Persiste o objeto pessoa no banco de dados
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(pessoa);
        tx.commit();

        // 4 - Executa a "named query"
        pessoa
                = em.createNamedQuery("encontrePessoaBruno", Pessoa.class).getSingleResult();

        // 5 - Encerra o EntityManager e o EntityManagerFactory
        em.close();
        emf.close();
    }
}
