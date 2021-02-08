package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.*;

public class SqlTrackerTest {

    public class TrackerSQLTest {

        public Connection init() {
            try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
                Properties config = new Properties();
                config.load(in);
                Class.forName(config.getProperty("driver-class-name"));
                return DriverManager.getConnection(
                        config.getProperty("url"),
                        config.getProperty("username"),
                        config.getProperty("password")

                );
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }

        @Test
        public void createItem() throws Exception {
            try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
                tracker.add(new Item("name", "desc"));
                assertThat(tracker.findByName("desc").size(), is(1));
            }
        }
    }
}