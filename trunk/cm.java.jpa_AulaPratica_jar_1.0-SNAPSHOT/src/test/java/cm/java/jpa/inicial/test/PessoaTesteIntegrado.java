
package cm.java.jpa.inicial.test;
import cm.java.jpa.inicial.Livro;
import cm.java.jpa.inicial.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PessoaTesteIntegrado {

    private static EntityManagerFactory emf  = 
           Persistence.createEntityManagerFactory("cmJavaJPATeste");

    private EntityManager em;
    private EntityTransaction tx;

    
    @Before
    public void iniciaGerenciadorEntidades() throws Exception {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void encerraGerenciadorEntidades() throws Exception {
        if (em != null) {
            em.close();
        }
    }

    @Test
    public void deveriaEncontrarPessoaMaria() throws Exception {
        Pessoa pessoa = em.find(Pessoa.class, 1001L);
        assertEquals("Maria", pessoa.getPrimeiroNome());
    }

    @Test
    public void deveriaCriarPessoaJose() throws Exception {
        Pessoa pessoa = new Pessoa("222222","Jose", "da Oliveira");
        tx.begin();
        em.persist(pessoa);
        tx.commit();

        assertNotNull("A ID não deveria ser nula", pessoa.getId());

        pessoa = em.createNamedQuery("encontrePessoaBruno", Pessoa.class).getSingleResult();
        assertEquals("Bruno Penha", pessoa.getPrimeiroNome() + " " + pessoa.getUltimoNome());
    }
    
    @Test
    public void deveriaCriaLivro() throws Exception {
        Livro livroAserInserido = new Livro();
       
       livroAserInserido.setDescricao("Livro teste");
       livroAserInserido.setTitulo("Moby Dick");
       livroAserInserido.setIsbn("1111-222");
       livroAserInserido.setNroDePaginas(134);
       livroAserInserido.setPreco(9.88f);
       
        
        tx.begin();
        em.persist(livroAserInserido);
        tx.commit();

        assertNotNull("A ID não deveria ser nula", livroAserInserido.getChavePrimaria());

    }

    @Test(expected = ConstraintViolationException.class)
    public void deveriaDarExcecaoViolacaoConstraint() {
        Pessoa pessoa = new Pessoa(null,"Sem Primeiro Nome ", "ultimo nome nulo");
        em.persist(pessoa);
    }
}
