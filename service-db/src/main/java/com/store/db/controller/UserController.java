package com.store.db.controller;

import com.store.db.entity.User;
import com.store.db.enums.ResultCode;
import com.store.db.service.IUserService;
import com.store.db.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@RestController
@RequestMapping("/db/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "验证用户名和密码")
    @RequestMapping(method = RequestMethod.GET)
    public ResultVo getUserByUname(String username){
        return new ResultVo(userService.getUserByUnameOrMobile(username));
    }

    @ApiOperation(value = "创建用户")
    @RequestMapping(method = RequestMethod.POST)
    public ResultVo createUser(@RequestBody User user){
        userService.save(user);
        return new ResultVo(ResultCode.SUCCESS);
    }

}
