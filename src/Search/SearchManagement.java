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

    @Override
    public boolean UpDate(Word word) {
        boolean flag = false;
        WordDao udd = new WordDaoImpl();
        if (udd.UpDate(word)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }


}


