package lch.museum_second.dao;


import lch.museum_second.domain.Treasure;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ITreasureDao {

    @Select("select * from treasure")
    List<Treasure> selectAll();

    @Select("select * from treasure where name like CONCAT('%',#{name},'%')")
    List<Treasure> selectByName(@Param("name") String name);

    @Select("select * from treasure where id = #{id}")
    List<Treasure> selectById(Integer id);

    @Select("select count(*) from treasure")
    int selectTreasureCount();


    @Update("UPDATE treasure SET " +
            "name=#{name}, " +
            "findplace=#{findPlace}, " +
            "owntime=#{ownTime}, " +
            "web=#{web}, " +
            "story=#{story}, " +
            "craft=#{craft}, " +
            "study=#{study}" +
            " WHERE id = #{id}")
    int updateTreasure(@Param("id") Integer id,
                          @Param("name") String name,
                          @Param("findPlace")String findPlace,
                          @Param("ownTime")String ownTime,
                          @Param("web")String web,
                          @Param("story")String story,
                          @Param("craft")String craft,
                          @Param("study")String study);

    @Insert("INSERT INTO treasure(`id`, `name`, `owntime`,  `findplace`, `web`, `story`, `craft`, `study`) VALUES (" +
            "#{id}, " +
            "#{name}, " +
            "#{findPlace}, " +
            "#{ownTime}, " +
            "#{web}, " +
            "#{story}, " +
            "#{craft}, " +
            "#{study});")
    int insertTreasure(@Param("id") Integer id,
                       @Param("name") String name,
                       @Param("findPlace")String findPlace,
                       @Param("ownTime")String ownTime,
                       @Param("web")String web,
                       @Param("story")String story,
                       @Param("craft")String craft,
                       @Param("study")String study);

    @Delete("delete from treasure where id = #{id}")
    int deleteTreasure(@Param("id") Integer id);
}
