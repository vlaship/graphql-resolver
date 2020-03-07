package vlaship.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Accessors(chain = true)
@Data
@Document(collection = "prices")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String brand;
    private String category;
    private String subCategory;
    private String vendorCode;
    @Field("nameProduct")
    private String productName;
    private BigDecimal price;
}
