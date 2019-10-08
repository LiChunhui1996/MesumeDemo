package lch.museum_second.service;

import lch.museum_second.dao.IAdminDao;
import lch.museum_second.dao.ITreasureDao;
import lch.museum_second.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private IAdminDao adminDao;

    public List<Admin> selectByTelephoneService(String telephone){
        return adminDao.selectByTelephone(telephone);
    }

    public List<Admin> selectByEmailService(String email){
        return adminDao.selectByEmail(email);
    }


}
