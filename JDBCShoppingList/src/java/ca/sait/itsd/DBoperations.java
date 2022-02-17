/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;
import java.sql.*;
/**
 *
 * @author Administrator
 */
public class DBoperations {
    
    public String getCartItems() {
        String items="";
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            String sql = "select * from listitems;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                if(!rs.getString(3).equals("0")){
                    items = items + rs.getString(1) + "+" + rs.getString(2) + ",";
                }
            }
            
            rs.close();
            st.close();
            cp.freeConnection(conn);
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return items;
    }
    
    public String getItems() {
        String items="";
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            String sql = "select * from listitems;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                if(rs.getString(3).equals("0")){
                    items = items + rs.getString(1) + "+" + rs.getString(2) + ",";
                }
            }
            
            rs.close();
            st.close();
            cp.freeConnection(conn);
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return items;
    }
    
    
    //Add item
    public boolean addItem(String item) {
        boolean result = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        String sql = "call addListItem(?);";
        
        try {
            Connection conn = cp.getConnection();
            CallableStatement st = conn.prepareCall(sql);
            
            st.setString(1,item); 
            
            int rowAffected = st.executeUpdate();
            
            result = (rowAffected>0);
            
            st.close();
            conn.close(); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            cp.freeConnection(conn);
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
     //delete item
    public boolean deleteItem(int item) {
        boolean result = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        String sql = "call deleteListItem(?);";
        
        try {
            Connection conn = cp.getConnection();
            CallableStatement st = conn.prepareCall(sql);
            
            st.setInt(1,item); 
            
            int rowAffected = st.executeUpdate();
            
            result = (rowAffected>0);
            
            st.close();
            conn.close(); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            cp.freeConnection(conn);
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
     //toggle cart
    public boolean toggleInCart(int item) {
        boolean result = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        String sql = "call toggleInCart(?);";
        
        try {
            Connection conn = cp.getConnection();
            CallableStatement st = conn.prepareCall(sql);
            
            st.setInt(1,item); 
            
            int rowAffected = st.executeUpdate();
            
            result = (rowAffected>0);
            
            st.close();
            conn.close(); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            cp.freeConnection(conn);
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
}
