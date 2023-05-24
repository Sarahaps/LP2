import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
public class TelaDeListagemDeLivros {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicativo");
        EntityManager em = emf.createEntityManager();

        try {
            List<Livro> livros = em.createQuery("SELECT u FROM Livro u", Livro.class).getResultList();

            if (!livros.isEmpty()) {
                System.out.println("Livros cadastrados:");

                for (Livro livro : livros) {
                    System.out.println("ID: " + livro.getId() + " | Título: " + livro.getNome() + " | Editora: "
                            + livro.getEditora() + " | Núm. de Páginas: " + livro.getPaginas() + " | Ano de Publicação: "
                            + livro.getAno() + " | Edição: " + livro.getEdicao());
                }
            } else {
                System.out.println("Não há livros cadastrados nesse sistema.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar cadastrar o livro." + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }
}
