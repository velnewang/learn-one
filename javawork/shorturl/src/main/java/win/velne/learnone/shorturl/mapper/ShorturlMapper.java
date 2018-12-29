package win.velne.learnone.shorturl.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import win.velne.learnone.shorturl.entity.Shorturl;

@Mapper
public interface ShorturlMapper {

    @Select("SELECT id,url,counts,create_time,last_time FROM `shorturl` WHERE `id`=#{id}")
    @Results(
        { @Result(column = "create_time", property = "createTime"),
                @Result(column = "last_time", property = "lastTime") }
    )
    Shorturl getById(long id);

    @Update("UPDATE `shorturl` SET counts=#{counts},last_time=#{lastTime} WHERE id=#{id}")
    void update(Shorturl shorturl);

    @Insert(
        "INSERT INTO `shorturl` (id,url,counts,create_time,last_time) VALUES"
                + "(#{id},#{url},#{counts},#{createTime},#{lastTime})"
    )
    void insert(Shorturl shorturl);

    @Delete("DELET FROM `shorturl` WHERE id=#{id}")
    void deleteById(long id);

}
