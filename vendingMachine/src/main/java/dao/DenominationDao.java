package dao;

import entity.Denomination;

import java.util.List;

public interface DenominationDao {

    boolean addDenomination(Long denomination, Long quantity) throws Exception;

    boolean updateDenomination(Long denomination, Long quantity) throws Exception;

    Denomination getDenomination(Long denomination) throws Exception;

    List<Denomination> getAllDenominations() throws Exception;

}
