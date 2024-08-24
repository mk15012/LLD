package entity;

import enums.Constraints;
import enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TableColumn {

    String name;
    Type type;
    Boolean isNull;
    Constraints constraint;

}
