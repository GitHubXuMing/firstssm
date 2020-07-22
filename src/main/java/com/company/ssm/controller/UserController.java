package com.company.ssm.controller;

import com.company.ssm.common.Res;
import com.company.ssm.common.ResEnum;
import com.company.ssm.dao.entity.User;
import com.company.ssm.service.IUserService;
import com.company.ssm.vo.QueryVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
    @RequestMapping(value = "user",method = RequestMethod.POST)
    public @ResponseBody
    Res addUser(User user){
        return userService.insert(user);
    }

    @RequestMapping(value = "user/{id}",method = RequestMethod.DELETE)
    public @ResponseBody Res delete(@PathVariable("id") Integer id){
        return userService.delete(id);
    }

    @RequestMapping(value = "user/{username}",method = RequestMethod.POST)
    public @ResponseBody Res exist(@PathVariable("username") String username){
        return userService.exist(username);
    }

    @RequestMapping(value = "users",method = RequestMethod.GET)
    public @ResponseBody Res findall(
            @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(value="size",required=false,defaultValue = "5") Integer size
    ){
        return userService.findByPage(page,size);
    }

    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
    public @ResponseBody Res findById(@PathVariable("id") Integer id){
        return userService.findById(id);
    }

    @RequestMapping(value = "user/login",method = RequestMethod.POST)
    public @ResponseBody Res login(
            @RequestParam String username,
            @RequestParam String password){
        return userService.login(username,password);
    }

    @RequestMapping(value = "newuser",method = RequestMethod.POST)
    public @ResponseBody Res update(User user){
        return userService.update(user);
    }

    @RequestMapping(value = "reg",method = RequestMethod.POST)
    public @ResponseBody Res reg(
            @RequestParam String username,
            @RequestParam String password){
        return userService.reg(username,password);
    }

    @RequestMapping(value = "dyusers",method = RequestMethod.GET)
    public @ResponseBody Res dynamicSelect(QueryVo vo){
        return userService.dynamicSelect(vo);
    }

    @RequestMapping(value = "upload.do",method = RequestMethod.POST)
    public @ResponseBody Res uploadFile(
            @RequestParam("fileFromClient") MultipartFile src,
            @RequestParam("username") String username,
            HttpServletRequest request){
        File target = null;
        if(src.isEmpty()){
            return Res.error();
        }
        target = new File(
                request.getSession().getServletContext().getRealPath("/img/"+username),
                "pic"+System.currentTimeMillis()+src.getOriginalFilename()
                );
        try {
            FileUtils.copyInputStreamToFile(src.getInputStream(),target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String absolutePath = target.getAbsolutePath().replace("\\","/");
        int index = absolutePath.indexOf("/img");
        String uri = absolutePath.substring(index);
        return target != null?Res.success(ResEnum.SUCCESS,uri):Res.error();
    }

}
