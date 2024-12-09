import java.util.HashMap;
import java.util.Map;

public class InMemoryDBImpl implements InMemoryDB {
    private Map<String, Integer> mainDB = new HashMap<>();
    private Map<String, Integer> transactionDB = null;

    @Override
    public Integer get(String key) {
        if (transactionDB != null && transactionDB.containsKey(key)) {
            return transactionDB.get(key);
        }
        return mainDB.getOrDefault(key, null);
    }

    @Override
    public void put(String key, int val) {
        if (transactionDB == null) {
            throw new IllegalStateException("No active transaction. Call begin_transaction() first.");
        }
        transactionDB.put(key, val);
    }

    @Override
    public void begin_transaction() {
        if (transactionDB != null) {
            throw new IllegalStateException("A transaction is already in progress.");
        }
        transactionDB = new HashMap<>(mainDB);
    }

    @Override
    public void commit() {
        if (transactionDB == null) {
            throw new IllegalStateException("No active transaction to commit.");
        }
        mainDB = transactionDB;
        transactionDB = null;
    }

    @Override
    public void rollback() {
        if (transactionDB == null) {
            throw new IllegalStateException("No active transaction to rollback.");
        }
        transactionDB = null;
    }
}
