package SpringProj.EntityETC;

import SpringProj.AdvicesAndExceptions.TargetFoundException;
import SpringProj.AdvicesAndExceptions.TargetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class NewsTypeService {

    @Autowired()
    private NewsTypeRepository newsTypeRepository;

    private static HashMap<Long, NewsType> map = new HashMap<>();

    public HashMap<Long, NewsType> getMap() {
        return getMap(false);
    }
    public HashMap<Long, NewsType> getMap(boolean force) {
        if (force || NewsTypeService.map.isEmpty()) {
            map.clear();
            for (NewsType each : newsTypeRepository.findAll()) {
                NewsTypeService.map.put(each.getId(), each);
            }
        }
        return NewsTypeService.map;
    }

    public NewsType addNewsType(NewsType newsType) {
        Long id = newsType.getId();
        if (id != null) {
            throw new TargetFoundException("News should not have id.");
        }
        return newsTypeRepository.save(newsType);
    }

    //cache invalidation problem может найти удалённое значение
    public Collection<NewsType> findAll() {
        return getMap().values();
    }

    //cache invalidation problem может найти удалённое значение
    public NewsType findById(Long id) {
        if (getMap().containsKey(id)) {
            return getMap().get(id);
        }
        if (getMap(true).containsKey(id)) {
            return getMap().get(id);
        }
        throw new TargetNotFoundException("NewsType not found.");
    }

    public String updateById(Long id, NewsType newsType) {
        NewsType newsTypeFromDB = findById(id);
        String oldNewsTypeString = newsTypeFromDB.toString();
        if (newsType.getId() != null && newsType.getId() != id) {
            throw new TargetNotFoundException("NewsType not found.");
        }
        newsType.setId(id);
        newsType.consume(newsTypeFromDB);
        newsTypeRepository.save(newsType);
        return oldNewsTypeString;
    }

    public NewsType deleteById(Long id) {
        NewsType old = findById(id);
        newsTypeRepository.deleteById(id);
        return old;
    }
}
