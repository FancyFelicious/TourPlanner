package at.technikum.tourplanner.database;

public class SQLQueries {
    public enum User {
        REGISTER("""
                INSERT INTO users (username, password) VALUES (?,?);
                INSERT INTO stats (user_id) VALUES (?);
                INSERT INTO inventory (user_id) VALUES (?);
                """),
        LOGIN("UPDATE users SET session_token = ? WHERE id = ?"),
        EDIT("UPDATE users SET name = ?, bio = ?, image = ? WHERE username = ?;"),
        FIND_BY_USERNAME("SELECT * from users WHERE username = ?;"),
        GET_ID("SELECT id from users WHERE username = ?;"),
        GET_ALL_USERS("SELECT * from users;"),
        GET_COINS("SELECT coins from inventory WHERE user_id = ?;"),
        PROCESS_TRANSACTION("UPDATE inventory SET coins = ? WHERE user_id = ?;"),
        GET_TRANSACTION_HISTORY("SELECT transaction_history from stats WHERE user_id=?;"),
        UPDATE_TRANSACTION_HISTORY("UPDATE stats SET transaction_history = ? WHERE user_id=?;");

        private final String query;

        User(String query) {
            this.query = query;
        }

        public String getQuery() {
            return query;
        }
    }


    public enum Card {
        FIND_BY_ID("SELECT * from cards WHERE id=?;"),
        CREATE_NEW_CARD("INSERT INTO cards (id, name, damage, element, type) VALUES (?, ?, ?, ?, ?);"),
        ADD_PACKAGE("INSERT INTO available_packages (id, package_content) VALUES (?, ?);"),
        GET_PACKAGE("WITH deleted_row AS ( DELETE FROM available_packages WHERE available_packages.id = ( SELECT id FROM available_packages ORDER BY id LIMIT 1) RETURNING *) SELECT * FROM deleted_row;"),
        GET_STACK("SELECT card_collection from inventory WHERE user_id=?;"),
        GET_DECK("SELECT battle_deck from inventory WHERE user_id=?;"),
        UPDATE_COLLECTION("UPDATE inventory SET card_collection = ? WHERE user_id = ?;"),
        UPDATE_BATTLE_DECK("UPDATE inventory SET battle_deck = ? WHERE user_id = ?;");

        private final String query;

        Card(String query) {
            this.query = query;
        }

        public String getQuery() {
            return query;
        }
    }
}


