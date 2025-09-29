package repo;
import com.example.entity.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarteRepo extends JpaRepository<Carte, String> {
    Carte findByIsbn(String isbn);

    void deleteByIsbn(String isbn);

    List<Carte> findByAutor(String autor);
}
