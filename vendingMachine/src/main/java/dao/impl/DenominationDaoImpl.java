package dao.impl;

import dao.DenominationDao;
import entity.Denomination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DenominationDaoImpl implements DenominationDao {

    private final Map<Long, Denomination> denominationMap;

    public DenominationDaoImpl() {
        denominationMap = new HashMap<>();
    }

    @Override
    public boolean addDenomination(Long denomination, Long quantity) throws Exception {
        if (Objects.nonNull(denominationMap.get(denomination))) {
            throw new Exception("Denomination " + denomination + " already exists");
        }

        Denomination value = new Denomination(denomination, quantity);
        denominationMap.put(denomination, value);
        return true;
    }

    @Override
    public boolean updateDenomination(Long denomination, Long quantity) throws Exception {
        if (Objects.isNull(denominationMap.get(denomination))) {
            throw new Exception("Denomination " + denomination + " doens't exists");
        }

        Denomination value = denominationMap.get(denomination);
        value.setQuantity(value.getQuantity() + quantity);
        denominationMap.put(denomination, value);
        return true;
    }

    @Override
    public Denomination getDenomination(Long denomination) throws Exception {
        if (Objects.isNull(denominationMap.get(denomination))) {
            throw new Exception("Denomination " + denomination + " doens't exists");
        }

        return denominationMap.get(denomination);
    }

    @Override
    public List<Denomination> getAllDenominations() throws Exception {
        return new ArrayList<>(denominationMap.values());
    }
}
