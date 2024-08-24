package entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Denomination {

    private Long denomination;
    private Long quantity;

}
