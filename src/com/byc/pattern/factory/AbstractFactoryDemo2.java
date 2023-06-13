package com.byc.pattern.factory;
// abstract factory
interface IDatabaseUtils {
    IConnection getConnection();
    ICommand executeCommand();
    default void close() {
        System.out.println("Database connection closed");
    }
}
interface IConnection {
    void connect();
}
interface ICommand {
    void execute();
}

class MySQLConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("MySQL connected");
    }
}

class MySQLCommand implements ICommand {

    @Override
    public void execute() {
        System.out.println("Execute MySQL commands");
    }
}

class MySQLDatabaseUtils implements IDatabaseUtils {

    @Override
    public IConnection getConnection() {
        return new MySQLConnection();
    }

    @Override
    public ICommand executeCommand() {
        return new MySQLCommand();
    }
}


public class AbstractFactoryDemo2 {
    public static void main(String[] args) {
        IDatabaseUtils databaseUtils = new MySQLDatabaseUtils(); // 不同的数据库只需要替换这一行代码即可
        IConnection connection = databaseUtils.getConnection();
        connection.connect();
        ICommand command = databaseUtils.executeCommand();
        command.execute();
        databaseUtils.close();
    }
}
