import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Id {
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
}
