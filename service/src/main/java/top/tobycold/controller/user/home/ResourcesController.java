package top.tobycold.controller.user.home;


import cn.hutool.core.io.FileUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.exception.ImageException;
import top.tobycold.util.Result;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequestMapping("user/resources")
@Tag(name = "资源请求接口")
public class ResourcesController {
    @Value("${main.path}")
    private String PathMain;

    @Operation(summary = "请求图片资源")
    @GetMapping("{date}/{name:.+}")
    public void getImage(@PathVariable(name = "date") String date, @PathVariable(name = "name") String name, HttpServletRequest request, HttpServletResponse response) {
        log.info("IP:{} -> 端发起请求图片资源,图片时间:{}, 图片名称:{}", request.getLocalAddr(), date, name);
        try {
            byte[] bytes = FileUtil.readBytes(PathMain + date + "//" + name);
            response.setContentLength(bytes.length);
            /**
             *  设置资源为下载
             * response.setHeader("Content-Disposition", "attachment; filename=\"video.mp4\"");
             */

            //使资源回显而不是下载
            response.setContentType("video/mp4");
            response.getOutputStream().write(bytes);
        } catch (Exception e) {
            throw new ImageException("没有这个资源");
        }
    }

    @Operation(summary = "查询所有文件映射路径")
    @GetMapping("all")
    public Result<?> getDAtaList(){
        log.info("查询所有文件映射路径");
        File file = new File(PathMain);
        String[] folder = file.list();

        List<Object> response = new ArrayList<>();

        Arrays.stream(folder).forEach((r)-> {
            File file1 = new File(PathMain + r);

            //子文件名
            String[] list = file1.list();
            String[] array = Stream.of(list).map(s -> "http://192.168.31.231:8888/api/data/" + r + "/" + s).toArray(String[]::new);
            response.add(array);
        });

        return Result.success("success", response.get(1));
    }

}
