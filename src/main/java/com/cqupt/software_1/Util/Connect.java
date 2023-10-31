package com.cqupt.software_1.Util;

import java.sql.*;

public class Connect {
    // 其他连接数据库的方法和属性...
    String url = "jdbc:mysql://10.16.48.219:3306/medical";
    String username = "root";
    String password = "111111";

    // 从数据库中查询数据并构建二维数组
    public int[][] fetchDataFromDatabase(String tableName) throws SQLException {
        int[][] table;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM " + tableName  + " limit 50000"; // 替换为你的表名
            try (PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    // 定位到最后一行
                    rs.last();
                    int numRows = rs.getRow();
                    rs.beforeFirst();

                    // 获取列数
                    ResultSetMetaData metaData = rs.getMetaData();
                    int numCols = metaData.getColumnCount();

//                    String[] columnNames = new String[numCols];
//
//                    for (int col = 0; col < numCols; col++) {
//                        columnNames[col] = metaData.getColumnName(col + 1);
//                        System.out.println(columnNames[col]);
//                    }

                    table = new int[numRows][numCols];

                    // 填充数据到二维数组
                    int row = 0;
                    while (rs.next()) {
                        for (int col = 0; col < numCols; col++) {
                            table[row][col] = rs.getInt(col + 1); // 注意索引从1开始
                        }
                        row++;
                    }
                }
            }
        }
        return table;
    }
}
