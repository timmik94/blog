package DAO;

import Hibernateclasses.Record;

import java.util.List;

/**
 * Created by timur on 14.06.2014.
 */
public interface RecordDao {
    public Record getrecord(long id);
    public void incertRecord(Record record);
    public List<Record>getRecordbyuser(String login);
}
