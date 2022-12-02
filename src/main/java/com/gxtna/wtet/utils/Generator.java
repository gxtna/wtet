package com.gxtna.wtet.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.fill.Column;

/**
 * @author gxtna
 * @date 2022/12/2 下午2:30
 * @desciption: 代码生成器
 */
public class Generator{
    // 数据库连接配置

    // 生成代码入口main方法
    public static void main(String[] args) {


        String property = System.getProperty("user.dir");
        FastAutoGenerator.create("jdbc:postgresql://localhost:5432/database", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("gxtna") // 设置作者
                            .enableSwagger()// 开启 swagger 模式
                            .outputDir(property+"/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.gxtna.wtet") // 设置父包名
                         ; // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("effect,recipe_record,region,season,weather")
                            .entityBuilder()
                            .enableLombok()
                            .enableChainModel()
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                            .serviceBuilder().formatServiceFileName("%sService");

                })
                .execute();
    }

}
