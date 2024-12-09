public class Main {
    public static void main(String[] args) {
        InMemoryDB db = new InMemoryDBImpl();

        // Example usage
        System.out.println(db.get("A")); // null

        try {
            db.put("A", 5); // Should throw an error
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        db.begin_transaction();
        db.put("A", 5);
        System.out.println(db.get("A")); // null (not committed)

        db.put("A", 6);
        db.commit();
        System.out.println(db.get("A")); // 6

        db.begin_transaction();
        db.put("B", 10);
        db.rollback();
        System.out.println(db.get("B")); // null
    }
}
