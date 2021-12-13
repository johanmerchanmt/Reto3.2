package mintic.reto1.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "supplements")
public class Cookware {

    @Id
    private String reference;

    private String brand;
    private String category;
    private String materiales;
    private String dimensiones;
    private String description;
    private boolean availability;
    private Double price;
    private Integer quantity;
    private String photography;
}
