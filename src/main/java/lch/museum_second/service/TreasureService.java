package lch.museum_second.service;

import lch.museum_second.dao.ITreasureDao;
import lch.museum_second.domain.Treasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TreasureService {

    @Autowired
    private ITreasureDao treasureDao;

    public List<Treasure> selectAllService(){
        return treasureDao.selectAll();
    }

    public List<Treasure> selectByNameService(String name){
        return treasureDao.selectByName(name);
    }

    public List<Treasure> selectByIdService(Integer id){
        return treasureDao.selectById(id);
    }

    public int updateTreasureService(Treasure treasure){
       return  treasureDao.updateTreasure(treasure.getId(), treasure.getName(), treasure.getFindPlace(),
                treasure.getOwnTime(), treasure.getWeb(), treasure.getStory(), treasure.getCraft(),
                treasure.getStudy());
    }

    public int deleteTreasureService(Integer id){
        return treasureDao.deleteTreasure(id);
    }

    public int selectTreasureCountService(){
        return treasureDao.selectTreasureCount();
    }


    public int insertTreasure(Treasure treasure){
        return treasureDao.insertTreasure(treasure.getId(), treasure.getName(), treasure.getFindPlace(),
                treasure.getOwnTime(), treasure.getWeb(), treasure.getStory(), treasure.getCraft(),
                treasure.getStudy());
    }


}
