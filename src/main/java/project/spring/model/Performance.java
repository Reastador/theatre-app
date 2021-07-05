package project.spring.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Performance performance = (Performance) o;
        return Objects.equals(id, performance.id)
                && Objects.equals(title, performance.title)
                && Objects.equals(description, performance.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }
}
