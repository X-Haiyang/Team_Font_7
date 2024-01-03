package Search;

import Dao.WordDao;
import Dao.WordDaoImpl;
import Entity.Word;

public class SearchManagement implements SearchService {
//搜索给定的单词。它首先创建一个WordDaoImpl对象，然后调用该对象的SearchWord方法来实际执行搜索操作。
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


