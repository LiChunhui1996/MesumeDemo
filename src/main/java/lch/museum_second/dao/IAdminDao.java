package lch.museum_second.dao;

import lch.museum_second.domain.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IAdminDao {

    @Results(id="resultMapForTelephoneLogin", value= {
            @Result(column = "admin_id", property = "id", id = true),
            @Result(column = "admin_name", property = "name"),
            @Result(column = "admin_email", property = "email"),
            @Result(column = "admin_telephone", property = "telephone"),
            @Result(column = "admin_password", property = "password"),
            @Result(column = "admin_rank", property = "rank"),
            @Result(column = "admin_department", property = "department")
    })
    @Select("select * from adminuser where admin_telephone = #{telephone}")
    List<Admin> selectByTelephone(String telephone);

    @Results(id="resultMapForEmailLogin", value= {
            @Result(column = "admin_id", property = "id", id = true),
            @Result(column = "admin_name", property = "name"),
            @Result(column = "admin_email", property = "email"),
            @Result(column = "admin_telephone", property = "telephone"),
            @Result(column = "admin_password", property = "password"),
            @Result(column = "admin_rank", property = "rank"),
            @Result(column = "admin_department", property = "department")
    })
    @Select("select * from adminuser where admin_email = #{email}")
    List<Admin> selectByEmail(String email);
}
