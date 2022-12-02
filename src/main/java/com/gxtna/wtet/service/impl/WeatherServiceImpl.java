package com.gxtna.wtet.service.impl;

import com.gxtna.wtet.entity.Weather;
import com.gxtna.wtet.mapper.WeatherMapper;
import com.gxtna.wtet.service.WeatherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 天气信息表 服务实现类
 * </p>
 *
 * @author gxtna
 * @since 2022-12-02
 */
@Service
public class WeatherServiceImpl extends ServiceImpl<WeatherMapper, Weather> implements WeatherService {

}
