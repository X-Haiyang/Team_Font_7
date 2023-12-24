package Search;

import Dao.WordDao;
import Dao.WordDaoImpl;
import Entity.Word;

public class SearchManagement implements SearchService {

    @Override
    public boolean SearchWord(Word word) {
        boolean flag = false;

        WordDao wdd = new WordDaoImpl();

        if (wdd.SearchWord(word)) {
            flag = true;
        } else {
            flag = false;
        }

        return flag;
    }

}


