package manager.impl;

import dao.DenominationDao;
import entity.Denomination;
import manager.DenominationManager;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DenominationManagerImpl implements DenominationManager {

    private DenominationDao denominationDao;

    @Override
    public boolean addDenomination(Long denomination, Long quantity) throws Exception {
        return denominationDao.addDenomination(denomination, quantity);
    }

    @Override
    public boolean updateDenomination(Long denomination, Long quantity) throws Exception {
        return denominationDao.updateDenomination(denomination, quantity);
    }

    @Override
    public Denomination getDenomination(Long denomination) throws Exception {
        return denominationDao.getDenomination(denomination);
    }

    @Override
    public List<Denomination> getAllDenominations() throws Exception {
        return denominationDao.getAllDenominations();
    }

}
