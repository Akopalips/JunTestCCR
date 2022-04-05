package SpringProj.EntityETC;

import SpringProj.AdvicesAndExceptions.TargetFoundException;
import SpringProj.AdvicesAndExceptions.TargetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public News addNews(News news) {
        Long id = news.getId();
        if (id != null) {
            throw new TargetFoundException("News should not have id.");
        }
        return newsRepository.save(news);
    }

    public List<News> findAll() {
        return (List<News>) newsRepository.findAll();
    }

    public News findById(Long id) {
        return newsRepository.findById(id).orElseThrow(
                () -> new TargetNotFoundException("News not found.")
        );
    }

    public String updateById(Long id, News news) {
        System.out.println(news);
        News newsFromDB = findById(id);
        String oldNewsString = newsFromDB.toString();
        if (news.getId() != null) {
            try {
                findById(news.getId());
                throw new TargetFoundException("Id already used.");
            } catch (TargetNotFoundException e) {}
        }else{
            news.setId(id);
        }
        news.consume(newsFromDB);
        System.out.println(news);
        newsRepository.save(news);
        return oldNewsString;
    }

    public News deleteById(Long id) {
        News old = findById(id);
        newsRepository.deleteById(id);
        return old;
    }

    public List<News> getByTypeId(Long typeId){
        return newsRepository.findByTypeId(typeId);
    }
}
