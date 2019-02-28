package com.mdh.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: madonghao
 * @Date: 2019/2/26 15:11
 */
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/bronze").hasRole("英勇黄铜")
                .antMatchers("/silver").hasRole("不屈白银")
                .antMatchers("/gold").hasRole("荣耀黄金")
                .antMatchers("/platinum").hasRole("华贵铂金")
                .antMatchers("/diamond").hasRole("璀璨钻石")
                .antMatchers("/master").hasRole("超凡大师")
                .antMatchers("/challenger").hasRole("最强王者");

        //启用登录功能，可以使用默认的登录页，这里使用自定义的login.html页面
        //http.formLogin().loginPage("/login");
        //自定义登陆页面
        http.formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin");
        //1、/login来到登陆页
        //2、重定向到/login?error表示登陆失败
        //3、更多详细规定
        //4、默认post形式的 /login代表处理登陆
        //5、一但定制loginPage；那么 loginPage的post请求就是登陆

        //启用注销功能，（需要提供一个action为/logout的form）并设置注销后访问的url，这里注销后跳转到首页
        http.logout().logoutSuccessUrl("/");//注销成功以后来到首页
        //1、访问 /logout 表示用户注销，清空session
        //2、注销成功会返回 /login?logout 页面

        //启用rememberMe功能，将用户信息保存在cookie中
        http.rememberMe().rememberMeParameter("remeber");
        //登陆成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录
        //点击注销会删除cookie
    }

    /**
     * 定义认证规则
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        //inMemoryAuthentication表示使用基于内存的验证，还可以使用基于数据库的验证等，
        // 使用BCrypt编码对密码进行加密,否则报错java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("bronze").password(new BCryptPasswordEncoder().encode("0110")).roles("英勇黄铜")
                .and()
                .withUser("silver").password(new BCryptPasswordEncoder().encode("0110")).roles("不屈白银")
                .and()
                .withUser("gold").password(new BCryptPasswordEncoder().encode("0110")).roles("荣耀黄金")
                .and()
                .withUser("platinum").password(new BCryptPasswordEncoder().encode("0110")).roles("华贵铂金")
                .and()
                .withUser("diamond").password(new BCryptPasswordEncoder().encode("0110")).roles("璀璨钻石")
                .and()
                .withUser("master").password(new BCryptPasswordEncoder().encode("0110")).roles("超凡大师")
                .and()
                .withUser("challenger").password(new BCryptPasswordEncoder().encode("0110")).roles("最强王者");

    }


}
