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
        if (news.getId() != null) {
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
        News newsFromDB = findById(id);
        String oldNewsString = newsFromDB.toString();
        if (news.getId() != null) {
            throw new TargetNotFoundException("Id cannot be modified");
        }
        news.setId(id);
        news.consume(newsFromDB);
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
