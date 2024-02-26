package br.cefet.sisbiblioteca.teste;

import org.junit.jupiter.api.*;

import br.cefet.sisbiblioteca.dao.LivroDao;
import br.cefet.sisbiblioteca.model.Genero;
import br.cefet.sisbiblioteca.model.Livro;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LivroDaoTeste {
    private LivroDao livroDao;
    private Livro livroTest;

    @BeforeEach
    public void setUp() {
        livroDao = new LivroDao();
        livroTest = new Livro();
        livroTest.setTitulo("Teste Livro");
        livroTest.setAutor("Autor Teste");
        
        Genero genero = new Genero();
        genero.setId(1);
        genero.setNome("Ficção");
        livroTest.setGenero(genero);
        livroTest.setQuantidadeEstoque(2);
        livroTest.setValor((float) 2);
        livroTest.setDataDePublicacao(new Date());
    }
    @Test
    public void testAdicionarLivro() throws SQLException {
        livroDao.adicionar(livroTest);
        assertNotNull(livroTest.getId());
    }


    @Test
    public void testDeletarLivro() throws SQLException {
        livroDao.adicionar(livroTest);
        assertNotNull(livroTest.getId());

        livroDao.deletar(livroTest.getId());
        assertNull(livroDao.getById(livroTest.getId()));
    }


    @Test
    public void testGetAll() throws SQLException {
        livroDao.adicionar(livroTest);
        List<Livro> livros = livroDao.getAll();
        assertTrue(livros.size() > 0);
        
        livroDao.deletar(livroTest.getId());
    }

    @Test
    public void testGetByTitulo() throws SQLException {
        livroDao.adicionar(livroTest);
        List<Livro> livrosByTitle = livroDao.getByTitulo("Teste");
        assertTrue(livrosByTitle.size() > 0);
        
        livroDao.deletar(livroTest.getId());
    }
}
