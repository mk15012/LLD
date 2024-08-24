package manager;

import entity.Denomination;

import java.util.List;

public interface DenominationManager {

    boolean addDenomination(Long denomination, Long quantity) throws Exception;

    boolean updateDenomination(Long denomination, Long quantity) throws Exception;

    Denomination getDenomination(Long denomination) throws Exception;

    List<Denomination> getAllDenominations() throws Exception;
}
