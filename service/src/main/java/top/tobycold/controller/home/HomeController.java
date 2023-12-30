package top.tobycold.controller.home;


import cn.hutool.core.io.FileUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.tobycold.dao.Articles;
import top.tobycold.dao.Essays;
import top.tobycold.util.Result;
import top.tobycold.exception.ImageException;
import top.tobycold.pojo.SummaryEntity;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequestMapping("api/data")
@CrossOrigin
@Tag(name = "主页接口")
public class HomeController {
    @Value("${main.path}")
    private String PathMain;

    @Operation(summary = "请求图片资源")
    @GetMapping("{date}/{name:.+}")
    public void getImage(@PathVariable(name = "date") String date, @PathVariable(name = "name") String name, HttpServletRequest request, HttpServletResponse response) {
        log.info("IP:{} -> 端发起请求图片资源,图片时间:{}, 图片名称:{}", request.getLocalAddr(), date, name);
        try {
            byte[] bytes = FileUtil.readBytes(PathMain + date + "//" + name);
            response.setContentLength(bytes.length);
            //设置资源为下载
            //response.setHeader("Content-Disposition", "attachment; filename=\"video.mp4\"");

            //使资源回显而不是下载
            response.setContentType("video/mp4");
            response.getOutputStream().write(bytes);
        } catch (Exception e) {
            throw new ImageException("没有这个资源");
        }
    }

    @Operation(summary = "请求文章")
    @GetMapping
    public Result<?> getArticles() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        String date = now.format(formatter);
        //一下都是测试数据，后期要验证登录后再放行资源
        ArrayList<SummaryEntity> articleEntities = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            SummaryEntity summaryEntity = SummaryEntity.builder()
                    .title("后端第" + (i + 1) + "篇文章")
                    .body("路上只我一个人，背着手踱着。这一片天地好像是我的;我也像超出了平常旳自己，到了另一世界里。我爱热闹，也爱冷静;爱群居，也爱独处。像今晚上，一个人在这苍茫旳月下，什么都可以想，什么都可以不想，便觉是个自由的人。白天里一定要做的事，一定要说的话，现在都可不理。这是独处的妙处，我且受用这无边的荷香月色好了。曲曲折折的荷塘上面，弥望旳是田田的叶子。叶子出水很高，像亭亭旳舞女旳裙。层层的叶子中间，零星地点缀着些白花，有袅娜(niǎo,nuó)地开着旳，有羞涩地打着朵儿旳;正如一粒粒的明珠，又如碧天里的星星，又如刚出浴的美人。微风过处，送来缕缕清香，仿佛远处高楼上渺茫的歌声似的。这时候叶子与花也有一丝的颤动，像闪电般，霎时传过荷塘的那边去了。叶子本是肩并肩密密地挨着，这便宛然有了一道凝碧的波痕。叶子底下是脉脉(mò)的流水，遮住了，不能见一些颜色;而叶子却更见风致了。月光如流水一般，静静地泻在这一片叶子和花上。薄薄的青雾浮起在荷塘里。叶子和花仿佛在牛乳中洗过一样;又像笼着轻纱的梦。虽然是满月，天上却有一层淡淡的云，所以不能朗照;但我以为这恰是到了好处——酣眠固不可少，小睡也别有风味的。月光是隔了树照过来的，高处丛生的灌木，落下参差的斑驳的黑影，峭楞楞如鬼一般;弯弯的杨柳的稀疏的倩影，却又像是画在荷叶上。塘中的月色并不均匀;但光与影有着和谐的旋律，如梵婀(ē)玲(英语violin小提琴的译音)上奏着的名曲。荷塘的四面，远远近近，高高低低都是树，而杨柳最多。这些树将一片荷塘重重围住;只在小路一旁，漏着几段空隙，像是特为月光留下的。树色一例是阴阴的，乍看像一团烟雾;但杨柳的丰姿，便在烟雾里也辨得出。树梢上隐隐约约的是一带远山，只有些大意罢了。树缝里也漏着一两点路灯光，没精打采的，是渴睡人的眼。这时候最热闹的，要数树上的蝉声与水里的蛙声;但热闹是它们的，我什么也没有。")
                    .date(date)
                    .looking(666)
                    .love(520)
                    .build();
            articleEntities.add(summaryEntity);
        }

//TODO 拆分成两个接口
        Articles cold = Articles.builder()
                .bodys(articleEntities)
                .total(articleEntities.size())
                .build();


        return Result.success("success", cold);
    }

    @GetMapping("card")
    public Result<?> getCard(){



        return Result.success("success");
    }

    @GetMapping("all")
    public Result<?> getDAtaList(){

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
