package com.hezy;

import com.hezy.mapper.UserMapper;
import com.hezy.pojo.User;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertUserTest() {
        // 1.通过实体类添加
        User user1 = new User();
        user1.setId(10);
        user1.setUsername("hezy");
        user1.setPhone("12345678910");
        user1.setPassword("123456");
        userMapper.insert(user1);

//        // 2.部分字段添加，可设置是否忽略。如下，没有设置的字段为null，如果数据库有设置默认值，默认值会生效
//        User user2 = new User();
//        user2.setUsername("hezy3");
//        userMapper.insertSelective(user2);
//
//        // 3.通过实体类添加，忽略掉未设置的，为null的属性，如果这些字段数据库有设置默认值，则默认值会生效
//        User user3 = new User();
//        user3.setId(3);
//        user3.setUsername("wangwu");
//        userMapper.insert(user3, true);
//
//        // 4.批量插入实体类数据
//        User user4 = new User();
//        user4.setId(4);
//        user4.setUsername("lisi");
//        User user5 = new User();
//        user5.setId(5);
//        user5.setUsername("zhaoliu");
//        user5.setPassword("123456");
//
//        ArrayList<User> userList = new ArrayList<>();
//        userList.add(user4);
//        userList.add(user5);
//        userMapper.insertBatch(userList);
//
//        // 5.插入或者更新，主键有值则更新，没有值则插入，不忽略null
//        // 如下，数据库有记录：1-zhangsan-dsaf，修改后为：1-zhangsan_fix-null
//        User user6 = new User();
//        user6.setId(1);
//        user6.setUsername("zhangsan_fix");
//        userMapper.insertOrUpdate(user6);
//
//        // 6.插入或者更新，主键有值则更新，没值则插入，忽略null
//        // 如下，数据库有记录：1-zhangsan-dsaf，修改后为：1-zhangsan_fix-dsaf
//        User user7 = new User();
//        user7.setId(1);
//        user7.setUsername("zhangsan_fix");
//        userMapper.insertOrUpdateSelective(user7);
//
//        // 7.插入或者更新，主键有值则更新，没有值则新增，可设置是否忽略
//        User user8 = new User();
//        user8.setId(1);
//        user8.setUsername("zhangsan");
//        userMapper.insertOrUpdate(user8, false);
//
//        // 8.UpdateWrapper新增数据，可以用MySQL的函数，如UUID()，生成随机字符串
//        User user9 = new User();
//        user9.setUsername("zhangsan");
//        User newUser = UpdateWrapper.of(user9).setRaw(User::getPassword, "UUID()").toEntity();
//        userMapper.insert(newUser);
    }

    @Test
    public void deleteUserTest() {
        // 1.根据主键删除，多个主键的需要传入数组，如100、101
        userMapper.deleteById(1);
//        userMapper.deleteById(new Integer[]{100, 101});
//
//        // 2.根据实体类删除，这里是考虑到复合主键的情况
//        User user1 = new User();
//        user1.setId(1);
//        user1.setUsername("zhangsan");
//        userMapper.delete(user1);
//
//        // 3.根据主键批量删除数据
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(3);
//        userMapper.deleteBatchByIds(list);
//
//        // 4.根据Map构建的条件删除数据，删除username为zhangsan的记录
//        HashMap<String, Object> conditionMap = new HashMap<>();
//        conditionMap.put("username", "zhangsan");
//        userMapper.deleteByMap(conditionMap);
//
//        // 5.根据查询条件删除数据，删除username为lisi的记录
//        QueryWrapper queryWrapper = QueryWrapper.create();
//        queryWrapper.where("username = 'lisi'");
//        userMapper.deleteByQuery(queryWrapper);
    }

    @Test
    public void updateUserTest() {
        // 1.根据实体类更新，需要设置主键
        User user1 = new User();
        user1.setId(9);
        user1.setUsername("lisi");
        user1.setPassword("456");
        userMapper.update(user1);

//        // 2.根据实体类更新，可设置是否忽略未设置的字段
//        User user2 = new User();
//        user2.setId(1);
//        user2.setUsername("lisi");
//        userMapper.update(user2, true);
//
//        // 3.根据Map构建的条件来更新，修改lisi的password为abcdef
//        HashMap<String, Object> conditionMap1 = new HashMap<>();
//        conditionMap1.put("username", "lisi");
//
//        User user3 = new User();
//        user3.setPassword("abcdef");
//        userMapper.updateByMap(user3, conditionMap1);
//
//        // 4.根据Map构建的条件来更新，可设置是否忽略未设置的字段
//        // 修改lisi的password为abcdef，username未设置为null，或者数据库有默认值为默认值
//        HashMap<String, Object> conditionMap2 = new HashMap<>();
//        conditionMap2.put("username", "lisi");
//
//        User user4 = new User();
//        user4.setPassword("abcdef");
//        userMapper.updateByMap(user4, false, conditionMap2);
//
//        // 5.根据查询条件来更新数据
//        // 修改username=lisi的password为123456
//        QueryWrapper queryWrapper1 = QueryWrapper.create();
//        queryWrapper1.where("username = 'lisi'");
//        User user5 = new User();
//        user5.setPassword("123456");
//        userMapper.updateByQuery(user5, queryWrapper1);
//
//        // 6.根据查询条件来更新数据，可设置是否忽略默认值
//        // 修改username=lisi的password为123456，username未设置为null，或者数据库有默认值为默认值
//        QueryWrapper queryWrapper2 = QueryWrapper.create();
//        queryWrapper2.where("username = 'lisi'");
//        User user6 = new User();
//        user6.setPassword("123456");
//        userMapper.updateByQuery(user6, false, queryWrapper2);
    }

    @Test
    public void selectUserTest() {
        // 1.根据主键查询数据
        User user1 = userMapper.selectOneById(10);
        System.out.println(user1);
//
//        // 2.根据实体类查询数据，考虑到复合主键的情况
//        User user = new User();
//        user.setId(1);
//        User user2 = userMapper.selectOneByEntityId(user);
//        System.out.println(user2);
//
//        // 3.根据Map构建的条件查询数据
//        HashMap<String, Object> conditionMap1 = new HashMap<>();
//        conditionMap1.put("username", "zhangsan");
//        User user3 = userMapper.selectOneByMap(conditionMap1);
//        System.out.println(user3);
//
//        // 4.根据查询条件查询数据
//        QueryWrapper queryWrapper = QueryWrapper.create();
//        queryWrapper.where("username = 'zhangsan'");
//        User user4 = userMapper.selectOneByQuery(queryWrapper);
//        System.out.println(user4);
//
//        // 5.根据多个主键查询多条数据
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        List<User> users1 = userMapper.selectListByIds(list);
//        System.out.println(users1);
//
//        // 6.根据Map构建的条件，查询多条数据
//        HashMap<String, Object> conditionMap2 = new HashMap<>();
//        conditionMap2.put("username", "zhangsan");
//        List<User> users2 = userMapper.selectListByMap(conditionMap2);
//        System.out.println(users2);
//
//        // 7.根据查询条件，查询多条数据
//        QueryWrapper queryWrapper2 = QueryWrapper.create();
//        queryWrapper2.where("username = 'zhangsan'");
//        List<User> users3 = userMapper.selectListByQuery(queryWrapper2);
//        System.out.println(users3);

//        // 8.分页查询，传入一个空的QueryWrapper表示全查分页
//        QueryWrapper queryWrapper3 = QueryWrapper.create();
//        Page<User> paginate = userMapper.paginate(1, 10, queryWrapper3);
//        System.out.println(paginate.getRecords());

        // 9.根据查询条件分页查询，分页查询username=zhangsan的记录
//        QueryWrapper queryWrapper4 = QueryWrapper.create();
//        queryWrapper4.where("username = 'zhangsan'");
//        Page<User> paginate2 = userMapper.paginate(2, 2, queryWrapper4);
//        System.out.println(paginate2.getRecords());
    }
}
