package SpringProj;

import SpringProj.AdvicesAndExceptions.TargetNotFoundException;
import SpringProj.EntityETC.NewsType;
import SpringProj.EntityETC.NewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/newsType")
@RestController
public class NewsTypeController {

    @Autowired
    private NewsTypeService newsTypeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/new")
    public String addNewsTypeAsJson(@RequestBody NewsType newsType) {
        if (newsType.getName() == null) {
            throw new TargetNotFoundException(
                    "Name is null. News was not created"
            );
        }
        return newsTypeService.addNewsType(newsType) + " created.";
    }

    @GetMapping()
    public String getAllNewsType() {
        StringBuilder builder = new StringBuilder();
        for (NewsType eachNews : newsTypeService.findAll()) {
            builder.append(eachNews).append("\n");
        }
        return builder.toString();
    }

    @GetMapping("/retakeFromDB")
    public String getAllNewsTypeFromDB(){
        newsTypeService.getMap(true);
        return getAllNewsType();
    }


    @GetMapping("/get/{id}")
    public String getNewsType(@PathVariable Long id) {
        return newsTypeService.findById(id).toString();
    }

    @PutMapping("/update/{id}")
    public String updateNewsType(@RequestBody NewsType newNewsType, @PathVariable Long id) {
        return newsTypeService.updateById(id, newNewsType) + " has been modified.";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNewsType(@PathVariable Long id) {
        return newsTypeService.deleteById(id) + " has been removed.";
    }

}
