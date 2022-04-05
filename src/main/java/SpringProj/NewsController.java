package SpringProj;

import SpringProj.AdvicesAndExceptions.TargetNotFoundException;
import SpringProj.EntityETC.News;
import SpringProj.EntityETC.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/news")
@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/new")
    public String addNewsAsJson (@RequestBody News news) {
        if (news.getName() == null || news.getTypeId() == null ){
            throw new TargetNotFoundException(
                    "Name or typeId is null. News was not created"
            );
        }
        return newsService.addNews(news) + " created.";
    }

    @GetMapping
    public String getAllNews() {
        StringBuilder builder = new StringBuilder();
        for(News eachNews : newsService.findAll()){
            builder.append(eachNews).append("\n");
        }
        return builder.toString();
    }

    @GetMapping("/get/{id}")
    public String getNews(@PathVariable Long id) {
        return newsService.findById(id).toString();
    }

    @PutMapping("/update/{id}")
    public String updateNews (@RequestBody News newNews, @PathVariable long id){
        return newsService.updateById(id, newNews) + " has been modified.";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNews(@PathVariable long id) {
        return newsService.deleteById(id) + " has been removed.";
    }

    @GetMapping("/typeFilter/{typeId}")
    public String getByTypeId(@PathVariable Long typeId){
        StringBuilder builder = new StringBuilder();
        for(News eachNews : newsService.getByTypeId(typeId)){
            builder.append(eachNews).append("\n");
        }
        return builder.toString();
    }
}
