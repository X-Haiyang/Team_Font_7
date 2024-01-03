package Dao;

import Entity.Word;

public interface WordDao {

    boolean SearchWord(Word word);
    String UrlDBSearch(Word word);
    boolean UpDate(Word word);


}
